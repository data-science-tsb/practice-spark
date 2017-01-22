package com.sparkpractice

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) = {
    //acquire the spark context
    val conf = new SparkConf().setAppName("word-count")
    val sc = new SparkContext(conf)

    //load the input file
    val textFile = sc.textFile(args(0))

    //perform count
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    //output the counts
    counts.saveAsTextFile(args(1))

    //terminate context
    sc.stop()
  }
}