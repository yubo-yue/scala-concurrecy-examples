package org.learningconcurrency.ch06

trait Animal {
  def speak
}
object Animal {
  private class Dog extends Animal {
    override def speak = { println("woof") }
  }

  private class Cat extends Animal {
    override def speak = { println("meow") }
  }
  
  def apply(s: String): Animal = {
    if (s == "dog") new Dog
    else new Cat
  }
}

object AnimalDemo extends App {
  val cat = Animal("cat")
  val dog = Animal("dog")
  
  cat.speak
  dog.speak
}