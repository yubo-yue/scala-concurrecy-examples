package org.learningconcurrency.ch10

object FlatMapDemo extends App {
  val bag = List("1", "2", "three", "4", "one hundred seventy five")
  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in))
    } catch {
      case e: Exception => None
    }
  }
  
  val r = bag.flatMap { x => toInt(x) }.sum
  println(s"result is $r")
  
  val list = "apple" :: "banana" :: 1 :: 2 :: Nil
  val strings = list.filter { 
    case s: String => true
    case _ => false
  }
  
  strings.foreach { x => println(x) }
  
  def onlyString(a: Any): Boolean = {
    a match {
      case s: String => true
      case _ => false
    }
  } 
  val strings1 = list.filter (onlyString)
  strings1.foreach(println)
  
  val x = (1 to 10).toArray
  val y = x.drop(3)
}