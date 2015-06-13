import CommonSettings._
import Dependencies._
import play.twirl.sbt.Import.TwirlKeys._
import ScoverageSbtPlugin.ScoverageKeys._

name := """playing-microservices"""

version := "1.0"

scalaVersion := scala

val scoverageSettings = Seq(
  coverageExcludedPackages := "<empty>;controllers.javascript;views.*;router",
  coverageExcludedFiles := "",
  coverageMinimum := 80,
  coverageFailOnMinimum := true
)

lazy val root = (
  project.in(file("."))
  aggregate(common, persistence, api, web, order, customer, payment)
)

lazy val common = (
  BaseProject("common")
  settings(libraryDependencies ++= playDependencies)
  settings(scoverageSettings: _*)
)

lazy val persistence = (
  PlayProject("persistence")
  settings(libraryDependencies ++= persistenceDependencies)
  settings(routesGenerator := InjectedRoutesGenerator)
  settings(scoverageSettings: _*)
) dependsOn(common)

lazy val customer = (
  PlayProject("customer-service")
  settings(libraryDependencies ++= playDependencies)
  settings(routesGenerator := InjectedRoutesGenerator)
  settings(scoverageSettings: _*)
) dependsOn(common)

lazy val order = (
  PlayProject("order-service")
  settings(libraryDependencies ++= playDependencies)
  settings(routesGenerator := InjectedRoutesGenerator)
  settings(scoverageSettings: _*)
) dependsOn(common)

lazy val payment = (
  PlayProject("payment-service")
  settings(libraryDependencies ++= playDependencies)
  settings(routesGenerator := InjectedRoutesGenerator)
  settings(scoverageSettings: _*)
) dependsOn(common)

lazy val api = (
  PlayProject("api")
  settings(libraryDependencies ++= playDependencies)
  settings(routesGenerator := InjectedRoutesGenerator)
  settings(scoverageSettings: _*)
) dependsOn(common)

lazy val web = (
  PlayProject("web")
  settings(libraryDependencies ++= webDependencies)
  settings(routesGenerator := InjectedRoutesGenerator)
  settings(scoverageSettings: _*)
) dependsOn(common)
