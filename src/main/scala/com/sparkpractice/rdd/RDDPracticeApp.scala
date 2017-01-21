package com.sparkpractice.rdd

import org.apache.spark.{SparkConf, SparkContext, SparkFiles}

/**
  *
  sbt assembly
  spark-submit --class com.sparkpractice.rdd.RDDPracticeApp C:\Users\LBibera\Desktop\spark-practice\target\scala-2.11\spark-practice-assembly-1.0.jar C:\Users\LBibera\Desktop\spark-data\Comments-Small.xml Comments-Small.xml
  */
object RDDPracticeApp {

  def main(args: Array[String]) = {
    val conf = new SparkConf()
      .setAppName("spark-practice-rdd")

    val sc = new SparkContext(conf)

    //easiest way to create an RDD is to load a file:
    sc.addFile(args(0)) //loads the file into the cluster
    val inFile = sc.textFile(SparkFiles.get(args(1)))
    inFile.first()
  }
}
