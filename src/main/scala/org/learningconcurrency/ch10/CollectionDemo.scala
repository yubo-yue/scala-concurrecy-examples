package org.learningconcurrency.ch10

object CollectionDemo extends App {
  var startTime = System.currentTimeMillis()
  var v = Vector[Int]()
  for (i <- 1 to 50000) v = v :+ i
  var endTime = System.currentTimeMillis()

  println(s"take ${endTime - startTime}")

  startTime = System.currentTimeMillis()
  var l = List[Int]()
  for (i <- 1 to 5000) l = l :+ i
  endTime = System.currentTimeMillis()
  println(s"take ${endTime - startTime}")

  var nums = scala.collection.mutable.ArrayBuffer(1, 2, 3)
  nums += 4
  nums += 5
  nums += (6, 7)
  nums ++= List(8, 9)
  nums.foreach(println)
  nums -= 9
  nums.foreach(println)

  val a = scala.collection.mutable.ArrayBuffer(1, 2, 3)
  a.append(4)
  a.append(5, 6)
  a.appendAll(Seq(7, 8))
  a.foreach(println)

  val fruits = Array("apple", "banana", "orange")
  for ((elem, count) <- fruits.zipWithIndex) {
    println(s"element $count is $elem")

  }
  
  for ((elem, count)<- fruits.zip(Stream from 1)) {
    println(s"fruit $count is $elem")
  }
  val newArr = for (e <- fruits) yield e.toUpperCase()
  newArr.foreach { x => println(x) }

  val names = Map("fname" -> "Ed", "lname" -> "Chigliak")
}