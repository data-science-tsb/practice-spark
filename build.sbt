name := "spark-practice"

version := "1.0"

scalaVersion := "2.11.8"

//https://cloud.google.com/dataproc/docs/concepts/dataproc-versions
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.11
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.2"

libraryDependencies += "com.databricks" % "spark-xml_2.11" % "0.4.1"

resolvers ++= Seq(
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Twitter4J Repository" at "http://twitter4j.org/maven2/"
)
// Only include if using assembly
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) => {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.first
  case PathList("org", "glassfish", xs @ _*) => MergeStrategy.first
  case PathList("org", "aopalliance", xs @ _*) => MergeStrategy.first
  case PathList("org", "apache", xs @ _*) => MergeStrategy.first
  case PathList("com", "databricks", xs @ _*) => MergeStrategy.first
  case "about.html" => MergeStrategy.rename
  case x => old(x)
}}