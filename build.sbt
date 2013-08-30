import com.typesafe.sbt.SbtStartScript

name := "example"

version := "1.0"

scalaVersion := "2.10.0"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo" at "http://repo.spray.io"
)

seq(Revolver.settings: _*)

seq(SbtStartScript.startScriptForClassesSettings: _*)

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % "2.1.0",
	"com.typesafe.akka" %% "akka-slf4j" % "2.1.0",
	"io.spray" % "spray-http" % "1.1-M7",
	"io.spray" % "spray-httpx" % "1.1-M7",
	"io.spray" % "spray-util" % "1.1-M7",
	"io.spray" % "spray-io" % "1.1-M7",
	"io.spray" % "spray-can" % "1.1-M7",
	"io.spray" % "spray-routing" % "1.1-M7",
	"io.spray" %% "spray-json" % "1.2.3",
	"org.parboiled" % "parboiled-core" % "1.1.4",
	"net.hamnaberg.rest" %% "scala-json-collection" % "2.0.1",
	"org.json4s" %% "json4s-native" % "3.2.4"
)