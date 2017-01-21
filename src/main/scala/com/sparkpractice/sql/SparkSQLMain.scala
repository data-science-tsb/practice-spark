package com.sparkpractice.sql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}

/**
  spark-submit --class com.sparkpractice.sql.SparkSQLMain C:\Users\LBibera\Desktop\spark-practice\target\scala-2.11\spark-practice-assembly-1.0.jar C:\Users\LBibera\Desktop\spark-data\Comments-Small.xml C:\Users\LBibera\Desktop\output.xml
 */
object SparkSQLMain {

  def main(args: Array[String]) = {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .getOrCreate()

    val customSchema = StructType(Array(
      StructField("Id", StringType, nullable = true),
      StructField("PostId", StringType, nullable = true),
      StructField("Text", StringType, nullable = true),
      StructField("CreationDate", StringType ,nullable = true),
      StructField("UserId", StringType, nullable = true)))

    val df = spark.sqlContext.read
      .format("com.databricks.spark.xml")
      .option("rootTag", "comments")
      .option("rowTag", "row")
      .schema(customSchema)
      .load(args(0))

    val selectedData = df
      .select("Id")
      .groupBy("Id").count()

    selectedData
      .write
      .format("com.databricks.spark.xml")
      .option("rootTag", "comments")
      .option("rowTag", "counts")
      .save(args(1))
  }
}
