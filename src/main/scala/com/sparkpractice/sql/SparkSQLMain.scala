package com.sparkpractice.sql

import org.apache.spark.sql.SparkSession

object SparkSQLMain {

  def main(args: Array[String]) = {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .getOrCreate()

    val df = spark.sqlContext.read
      .format("com.databricks.spark.xml")
      .option("rootTag", "Comments")
      .option("rowTag", "row")
      .load(args(0))

    val selectedData = df
      .groupBy("Id").count()

    selectedData
      .write
      .save(args(1))
  }
}
