package org.learningconcurrency.ch02

object ByNameParameter extends App {
  def runTwice(body: =>Unit) {
    body
    body
  }
  
  runTwice {
    println("Hello")
  }
  
  val successors = Map(1->2, 2->3, 3->4)
  successors.get(5) match {
    case Some(n) => println(s"Successor is: $n")
    case None => println(s"Could not find successor.")
  }
}