enablePlugins(TutPlugin)
val catsRetryVersion = "0.2.5"

name := "cats"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
    "org.typelevel"         %% "cats-core"           % "1.2.0",
    "com.chuusai"           %% "shapeless"           % "2.3.3",
    "com.github.cb372" %% "cats-retry-core"        % catsRetryVersion,
    "com.github.cb372" %% "cats-retry-cats-effect" % catsRetryVersion
)