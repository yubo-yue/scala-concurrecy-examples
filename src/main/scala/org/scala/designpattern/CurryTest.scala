package org.scala.designpattern

import java.io.PrintWriter
import java.io.File
import java.util.Date

object Printer {
  def write(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}

object CurryTest extends App {
  def sum(x: Int)(y: Int) = x + y
  println(sum(2)(4))

  val plusOne = sum(1)_
  println(plusOne(2))
  import Printer._
  val file = new File("/tmp/date.txt")
  val fileWriter = write(file)_
  fileWriter {
    _ println new Date
  }
}