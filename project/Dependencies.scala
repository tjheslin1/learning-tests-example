import sbt._

object Dependencies {

  val circeVersion = "0.9.3"
  val json4sVersion = "3.5.3"

  val json4s = "org.json4s" %% "json4s-native" % json4sVersion
  val scalatest = "org.scalatest" %% "scalatest" % "3.0.5" % Test

  val circeCore = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val circeParser = "io.circe" %% "circe-parser" % circeVersion
}
