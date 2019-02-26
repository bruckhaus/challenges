package spark

import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/Users/tilmannbruckhaus/dev/spark-1.2.0-bin-hadoop2.4/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
