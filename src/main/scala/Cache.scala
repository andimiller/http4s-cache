package net.andimiller
package http4s
package cache

import net.jodah.expiringmap.{ExpirationPolicy, ExpiringMap}

import scala.concurrent.duration._

trait Cache[K, V] {
  def get(k: K): Option[V]
  def put(k: K, v: V, d: FiniteDuration)
}

trait CacheFactory[T[_, _]] {
  def create[K, V](): Cache[K, V]
}

object CacheFactory {
  implicit object ExpiringMapCacheFactory extends CacheFactory[ExpiringMap] {
    override def create[K, V](): Cache[K, V] = {
      val em: ExpiringMap[K, V] = ExpiringMap
        .builder()
        .variableExpiration()
        .expirationPolicy(ExpirationPolicy.CREATED)
        .build()
        .asInstanceOf[ExpiringMap[K, V]]
      new Cache[K, V] {
        override def get(k: K): Option[V]                     = Option(em.get(k))
        override def put(k: K, v: V, d: FiniteDuration): Unit = em.put(k, v, d.length, d.unit)
      }
    }
  }

}