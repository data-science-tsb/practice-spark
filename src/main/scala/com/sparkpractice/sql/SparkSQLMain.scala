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
      .option("rowTag", "comment")
      .load(args(0))

    val selectedData = df.select("COUNT(*) as my_count")

    selectedData
      .write
      .format("com.databricks.spark.xml")
      .option("rootTag", "computed")
      .option("rowTag", "count")
      .save(args(1))
  }
}
