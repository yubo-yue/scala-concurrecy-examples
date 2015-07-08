package org.learningconcurrency.ch11

object SortableSetDemo extends App {
  val s = scala.collection.SortedSet(10, 4, 8, 2)
  s.foreach(println)
  
  val s2 = scala.collection.SortedSet("cherry", "kivi", "apple")
  s2.foreach(println)
  
  var s3 = scala.collection.mutable.LinkedHashSet(10, 4, 2, 8)
  s3.foreach(println)
  
  class Person(var name: String) extends Ordered[Person] {
    override def toString = name
    
    def compare (that: Person) = {
      if (this.name == that.name)
        0
      else if (this.name > that.name)
        1
      else
        -1
    }
  }
  val aleka = new Person("Aleka")
  val christina = new Person("Christina")
  val molly = new Person("Molly")
  val tyler = new Person("Tyler")
  val ss = scala.collection.SortedSet(aleka, christina, tyler, molly)
  ss.foreach(println)
  
  val x = List.tabulate(5)(_ + 1)
  x.foreach(println)
  
}