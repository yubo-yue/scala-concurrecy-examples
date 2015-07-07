package org.learningconcurrency.ch04

abstract class Pet(name: String) {
  val greeting: String
  var age: Int
  def sayHello = {println(greeting)}
  override def toString = s"I say $greeting, and i am $age"
}

class Dog(name: String) extends Pet(name) {
  val greeting = "Woof"
  var age = 5
}

class Cat(name: String) extends Pet(name) {
  val greeting = "Meow"
  var age = 10
}

object AbstractFieldDemo extends App {
  val dog = new Dog("Fido")
  val cat = new Cat("Morris")
  dog.sayHello
  cat.sayHello
  
  println(dog)
  println(cat)
}