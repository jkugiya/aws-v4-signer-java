name := "aws-v4-signer-java"

version := "1.2-SNAPSHOT"

scalaVersion := "2.11.8"

autoScalaLibrary := false

compileOrder := CompileOrder.JavaThenScala
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12" % "test",
  "org.assertj" % "assertj-core" % "3.2.0" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

