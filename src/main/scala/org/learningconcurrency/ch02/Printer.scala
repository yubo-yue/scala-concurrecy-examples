package org.learningconcurrency.ch02

class Printer (val greeting: String){
  def printMessage(): Unit = println(greeting + "!")
  def printNumber(x: Int): Unit = {
    println("Number: " + x)
  }
}

object Printer extends App {
  val printy = new Printer("Hi")
  printy.printMessage()
  printy.printNumber(100)
}