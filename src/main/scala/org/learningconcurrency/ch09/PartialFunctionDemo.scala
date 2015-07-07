package org.learningconcurrency.ch09

object PartialFunctionDemo extends App {
  val sum = (a: Int, b: Int, c: Int) => a + b + c
  val f = sum(1, 2, _: Int)

  println(f(3))
  println(f(5))

  def wrap(prefix: String, html: String, suffix: String) = {
    prefix + html + suffix
  }
  
  val wrapWithDiv = wrap("<DIV>", _: String, "</DIV>")
  println(wrapWithDiv("hello world"))
}