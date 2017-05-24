import sbt._
import Keys._
import play.PlayScala

object CommonSettings {

  val projectSettings = Seq(
    organization := "com.knoldus",
    scalaVersion := Dependencies.scala,
    resolvers ++= Dependencies.resolvers,
    fork in Test := true,
    parallelExecution in Test := true
  )

  def BaseProject(name: String): Project = (
    Project(name, file(name))
    settings(projectSettings:_*)
  )

  def PlayProject(name: String): Project = (
    BaseProject(name)
    enablePlugins(PlayScala)
  )
  
}
