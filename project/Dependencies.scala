import sbt._

object Dependencies {
  import sbt.Test

  val scalazVersion = "7.1.+"

  val scalazDeps = List(
    "org.scalaz" %% "scalaz-core" % scalazVersion,
    "org.scalaz" %% "scalaz-concurrent" % scalazVersion
  )

  val scalatestVersion = "2.2.4"

  val simulacrumDeps = List(
    "com.github.mpilquist" %% "simulacrum" % "0.5.+"
  )

  val argonautVersion = "6.1"

  val argonautDeps = List(
    "io.argonaut" %% "argonaut" % argonautVersion,
    "com.github.alexarchambault" %% s"argonaut-shapeless_$argonautVersion" % "1.0.0-SNAPSHOT"
  )

  val scalatestDeps = List(
    "org.scalatest" %% "scalatest" % scalatestVersion % Test
  )

  val http4sVersion = "0.12.1"
  val http4sDeps = List(
    "org.http4s" %% "http4s-dsl" % http4sVersion,  // to use the core dsl
    "org.http4s" %% "http4s-blaze-server" % http4sVersion  // to use the blaze backend
  )
}
