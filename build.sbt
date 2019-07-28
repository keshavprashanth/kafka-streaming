name := "KafkaDemo"

version := "0.2"

scalaVersion := "2.10.5"
retrieveManaged := true

// Use kafka-clients and kafka versions compatible with spark and kafka used in Cloudera VM.
// Cloudera VM uses spark 1.6 with scala 2.10.5.
// Kafka 0.10.0.0  with scala 2.10

// typesafe config is used to externalize the properties.
libraryDependencies += "com.typesafe" % "config" % "1.3.2"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.0.0"
libraryDependencies += "org.apache.kafka" % "kafka_2.10" % "0.10.0.0"
