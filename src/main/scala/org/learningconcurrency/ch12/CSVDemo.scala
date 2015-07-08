package org.learningconcurrency.ch12
import org.learningconcurrency.util.FileUtils
object CSVDemo extends App {
  println("Month, Income, Expenses, Profit")

  val bufferedSource = io.Source.fromFile("/tmp/finance.csv")
  FileUtils.using(bufferedSource) { source =>
    for (line <- source.getLines()) {
      val cols = line.split(",").map { x => x.trim() }
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
  }
}