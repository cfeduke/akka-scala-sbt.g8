import sbt._
import sbt.Keys._

object Build extends sbt.Build {

  lazy val project = Project(
    id = "$name;format="norm"$",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "$name$",
      organization := "$organization$",
      version := "$version$",
      scalaVersion := "$scala_version",
      libraryDependencies ++= Dependencies()
    )
  )

  object Dependencies {

    object Versions {
      val akka = "$akka_version$"
    }

    val compileDependencies = Seq(
      "com.typesafe.akka" %% "akka-actor" % Versions.akka
    )

    val testDependencies = Seq(
      "com.typesafe.akka" %% "akka-testkit" % Versions.akka % "test"
    )

    def apply(): Seq[ModuleID] = compileDependencies ++ testDependencies

  }

}
