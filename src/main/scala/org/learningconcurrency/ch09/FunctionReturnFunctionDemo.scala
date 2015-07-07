package org.learningconcurrency.ch09

object FunctionReturnFunctionDemo extends App {
  def greeting(language: String) = (name: String) => {
    val english = () => "hello, " + name
    val spanish = () => "Buenos dias, " + name
    language match {
      case "english" => println("returning 'english' function")
                                      english()
      case "spanish" => println("returning 'spanish' function")
                                      spanish()
    }
  }
  
  val hello = greeting("english")
  println(hello("Hi"))
  
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }
  
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }
  
  val convertLowNumToString = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    def apply(i: Int) = nums(i)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }
  
  val convert1to5 = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    def apply(i: Int) = nums(i - 1)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }
  
  val convert6to10 = new PartialFunction[Int, String] {
    val nums = Array("six", "seven", "eight", "nine", "ten")
    def apply(i: Int) = nums(i - 6)
    def isDefinedAt(i: Int) = i > 5 && i < 11
  }
  
  val handle1to10 = convert1to5 orElse convert6to10
  
  println(handle1to10(3))
  println(handle1to10(7))
  println(handle1to10.isDefinedAt(0))
  
  divide.isDefinedAt(1)
  
  List(0, 1, 2).collect(divide)
}