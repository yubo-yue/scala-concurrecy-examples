package org.learningconcurrency.ch06

class Person {
  var name: String = _
}

object Person {
  def apply(name: String): Person = {
    var p = new Person
    p.name = name
    p
  }
}

object PersonDemo extends App {
  val dawn = Person("Dawn")
  val a = Array(Person("Dan"), Person("Elijah"))
  
  
}