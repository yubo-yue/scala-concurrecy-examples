name := "yubo-concurrency-examples"
version := "1.0"
scalaVersion := "2.11.1"

resolvers ++= Seq(
    "Sonatype OSS Snapshots" at
        "https://oss.sonatype.org/content/repositories/snapshots",
    "Sonatype OSS Releases" at
        "https://oss.sonatype.org/content/repositories/releases",
    "Typesafe Repository" at
        "https://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies += "commons-io" % "commons-io" % "2.4"
libraryDependencies += "joda-time" % "joda-time" % "2.8.1"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"
fork := false
