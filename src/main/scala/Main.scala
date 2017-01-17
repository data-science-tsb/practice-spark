import org.apache.spark.{SparkConf, SparkContext}

object Main {
  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("spark-practice")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile(args(0))
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.saveAsTextFile(args(1))
    sc.stop()
  }
}