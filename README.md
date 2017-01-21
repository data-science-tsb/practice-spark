# Spark Practice
Some silly code to test out spark

## Pre-requisites
- install jdk8
- set java_home
- install sbt

## To build:
-  run the following command:
```
sbt package
```

Spark Notes

Spark:
Deploying on EC2:
https://github.com/amplab/spark-ec2#readme

Running On Windows:
http://nishutayaltech.blogspot.com/2015/04/how-to-run-apache-spark-on-windows7-in.html

Important Files:
C:\\Users\\Lbibera\\Desktop\\spark-data\\Comments.xml
C:\\Users\\Lbibera\\Desktop\\spark-data\\Posts.xml
C:\\Users\\Lbibera\\Desktop\\spark-data\\Users.xml
C:\\Users\\Lbibera\\Desktop\\spark-data\\Votes.xml
C:\\Users\\Lbibera\\Desktop\\spark-data\\spam.data

# Spark Shell:

## Add file in the context of all machines:
```scala
import org.apache.spark.SparkFiles
val file = sc.addFile("C:\\Users\\Lbibera\\Desktop\\spark-data\\Comments.xml")
val inFile = sc.textFile(SparkFiles.get("Comments.xml"))
```

## Spark Submit
```
spark-submit --class org.apache.spark.examples.GroupByTest C:\Users\LBibera\Desktop\spark-practice\target\scala-2.11\spark-practice_2.11-1.0.jar 10 10 10 10

spark-submit --class com.sparkpractice.sql.SparkSQLMain C:\Users\LBibera\Desktop\spark-practice\target\scala-2.11\spark-practice_2.11-1.0.jar C:\Users\LBibera\Desktop\output C:\Users\LBibera\Desktop\spark-data\Comments.xml
```

## SBT Assembly
```
sbt assembly

spark-submit --class com.sparkpractice.sql.SparkSQLMain C:\Users\LBibera\Desktop\spark-practice\target\scala-2.11\spark-practice-assembly-1.0.jar C:\Users\LBibera\Desktop\spark-data\Comments-Small.xml C:\Users\LBibera\Desktop\output 
```