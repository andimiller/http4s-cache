name := "http4s-cache"

version := "1.0"

scalaVersion := "2.11.8"

val HTTP4S_VERSION = "0.15.3a"

libraryDependencies ++= Seq(
  // frameworks
  "org.http4s"                       %% "http4s-core"               % HTTP4S_VERSION,
  "org.http4s"                       %% "http4s-dsl"                % HTTP4S_VERSION,
  "org.http4s"                       %% "http4s-circe"              % HTTP4S_VERSION,
  // circe generic
  "io.circe"                         %% "circe-generic"             % "0.4.1",
  // an expiring map
  "net.jodah"                        % "expiringmap"                % "0.5.7"
)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "2.2.4"   % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.0"  % "test"
)

