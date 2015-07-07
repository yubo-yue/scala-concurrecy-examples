package org.learningconcurrency.ch06

object ObjectDemo extends App {
  //determining the Class of an Object
  def printAll(ints: Int*) {
    println("Class: " + ints.getClass)
  }

  printAll(1, 2, 3)
  printAll()

  val hello = <p>Hello, world</p>
  println(hello.getClass)

  hello.child.foreach(e => println(e.getClass))

  def printClass(c: Any) { println(c.getClass) }
  printClass(1)
  printClass("Apple")
}