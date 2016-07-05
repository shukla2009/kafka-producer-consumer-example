name := """kafka-producer-consumer-example"""

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.0.0"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.10.0.0"


// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

