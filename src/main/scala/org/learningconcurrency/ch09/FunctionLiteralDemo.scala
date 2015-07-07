package org.learningconcurrency.ch09

object FunctionLiteralDemo extends App {

  val add = (x: Int, y: Int) => { x + y }
  val addThenDouble: (Int, Int) => Int = (x, y) => {
    val a = x + y
    2 * a
  }

  def modMethod(i: Int) = i % 2 == 0
  val list = List.range(1, 10)
  list.filter(modMethod).foreach { println }
  val c = scala.math.cos _
  println(c(10))
  val p = scala.math.pow(_, _)
  println(p(scala.math.E, 2))

  def executeFunction(callback: () => Unit) {
    callback()
  }

  def executeXTimes(callback: () => Unit, numTimes: Int) {
    for (i <- 1 to numTimes) callback()
  }

  def executeAndPrintf(f: (Int, Int) => Int, x: Int, y: Int) {
    val result = f(x, y)
    println(result)
  }

  val sum = (x: Int, y: Int) => x + y
  val multiply = (x: Int, y: Int) => x * y

  val sayHello = () => { println("Hello") }
  executeFunction(sayHello)
  executeXTimes(sayHello, 2)
  executeAndPrintf(sum, 10, 20)
  executeAndPrintf(multiply, 10, 20)

  def exec(callback: (Any, Any) => Unit, x: Any, y: Any) {
    callback(x, y)
  }

  val printTwoThings = (a: Any, b: Any) => {
    println(a)
    println(b)
  }

  case class Person(name: String)
  exec(printTwoThings, Person("Dave"), "Hello")
}