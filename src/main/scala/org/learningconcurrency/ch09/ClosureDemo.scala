package org.learningconcurrency.ch09

object ClosureDemo extends App {
  class Foo {
    def exec(f:(String) => Unit, name: String) {
      f(name)
    }
  }
  
  var hello = "Hello"
  def sayHello(name: String) {println(s"$hello, $name")}
  val foo = new Foo
  foo.exec(sayHello, "AL")
  hello = "Holo"
  foo.exec(sayHello, "Lorenzo")
  
  
  import scala.collection.mutable.ArrayBuffer
  
  val fruits = ArrayBuffer("Apple")
  val addToBasket = (s: String) => {
    fruits += s
    println(fruits.mkString(", "))
  }
  
  def buyStuff(f: String => Unit, s: String) {
    f(s)
  }
  
  buyStuff(addToBasket, "cherries")
  buyStuff(addToBasket, "grapes")
}