import sbt._
import Keys._

object Dependencies {

  val scala = "2.11.6"

  val resolvers = DefaultOptions.resolvers(snapshot = true) ++ Seq(
    "scalaz-releases" at "http://dl.bintray.com/scalaz/releases"
  )

  object playframework {
    val version      = play.core.PlayVersion.current

    val jdbc         = "com.typesafe.play"   %% "play-jdbc"                % version
    val cache        = "com.typesafe.play"   %% "play-cache"               % version
    val ws           = "com.typesafe.play"   %% "play-ws"                  % version
    val json         = "com.typesafe.play"   %% "play-json"                % version
    val specs2       = "com.typesafe.play"   %% "play-specs2"              % version            % "test"
  }

  object webjars {
    val webjarsplay  = "org.webjars"         %% "webjars-play"             % "2.4.0-1"
    val bootstrap    = "org.webjars"         %  "bootstrap"                % "3.3.4"
    val requirejs    = "org.webjars"         %  "requirejs"                % "2.1.18"
    val jquery       = "org.webjars"         %  "jquery"                   % "2.1.4"
    val fontawesome  = "org.webjars"         %  "font-awesome"             % "4.3.0-2"
  }

  val logback        = "ch.qos.logback"      %  "logback-classic"          % "1.1.3"
  val slick          = "com.typesafe.slick"  %% "slick"                    % "3.0.0"
  val postgresql     = "org.postgresql"      % 	"postgresql" 		   % "9.4-1201-jdbc41"
  val h2database     = "com.h2database"      %  "h2"                       % "1.4.187"          % "test"
  val scalatest      = "org.scalatest"       %% "scalatest"                % "2.2.4"            % "test"

  val playDependencies: Seq[ModuleID] = Seq(
    playframework.jdbc,
    playframework.cache,
    playframework.ws,
    playframework.json,
    playframework.specs2
  )

  val webjarsDependencies: Seq[ModuleID] = playDependencies ++ Seq(
    webjars.webjarsplay,
    webjars.bootstrap,
    webjars.requirejs,
    webjars.jquery,
    webjars.fontawesome
  )

  val webDependencies: Seq[ModuleID] = playDependencies ++ webjarsDependencies

  val persistenceDependencies: Seq[ModuleID] = playDependencies ++ Seq(
    postgresql,
    slick,
    h2database
  )

}
