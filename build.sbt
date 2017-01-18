name := "spark-practice"

version := "1.0"

scalaVersion := "2.11.8"

//https://cloud.google.com/dataproc/docs/concepts/dataproc-versions
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.11
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.2"

libraryDependencies += "com.databricks" % "spark-xml_2.11" % "0.4.1"