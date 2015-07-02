package org.learningconcurrency.ch03

import org.learningconcurrency.ch02._
object ControlStructure extends App {
  val a = Array("apple", "banana", "orange")
  for (e <- a) log(e)

  //returning value from a loop
  val newArray = for (e <- a) yield e.toUpperCase()
  log(newArray.mkString(" "))

  //Using for loop with multiple counters
  for (i <- 1 to 2; j <- 1 to 2) log(s"i = $i, j = $j")

  for {
    i <- 1 to 2
    j <- 1 to 2
  } log(s"i = $i, j = $j")

  for {
    i <- 1 to 3
    j <- 1 to 5
    k <- 1 to 10
  } log(s"i = $i, j = $j, k = $k")

  val array = Array.ofDim[Int](2, 2)
  array(0)(0) = 0
  array(0)(1) = 1
  array(1)(0) = 2
  array(1)(1) = 3

  log("====================")
  log("multi dimensions array")

  for {
    i <- 0 to 1
    j <- 0 to 1
  } log(s"($i)($j) = ${array(i)(j)}")

  log("====================")
  log("for loop with filters")
  for {
    i <- 1 to 10
    if i % 2 == 0
  } log(s"$i")

  log("====================")
  log("multiple filters")
  for {
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  } log(s"$i")

  log("====================")
  log("creating for comprehensio(for/yield combination)")

  val names = Array("apple", "banana", "orange")
  val lengths = for (e <- names) yield e.length
  log(lengths(1).toString())

  log("Implementing break and continue")
  import scala.util.control.Breaks._
  breakable {
    for (i <- 1 to 10) {
      log(i.toString)
      if (i > 4) break
    }
  }

  import scala.annotation.tailrec

  def factorial(n: Int): Int = {
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1) acc
      else factorialAcc(n * acc, n - 1)
    }

    factorialAcc(1, n)
  }

  log("Using patternmatching in Match Expressions")

  case class Person(val first: String, val last: String)

  def echoWhatYouGaveMe(x: Any): String = x match {
    case 0 => "Zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty list"

    case List(0, _, _) => "a three-element list with 0 as the first element"
    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector starting with 1, having any number of elements"

    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a and $b and $c"
    case Person(first, "Alexander") => s"Found an alexander, first name = $first"
    
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thansk for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(" ")}"
    case m: Map[_, _] => m.toString
  }

  log(echoWhatYouGaveMe(Person("a", "Alexander")))
}