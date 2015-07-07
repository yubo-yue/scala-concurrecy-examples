package org.learningconcurrency.ch04

class PandorasBox {
  case class Thing(name: String)
  var things = new collection.mutable.ArrayBuffer[Thing]()
  things += Thing("Evil thing #1")
  things += Thing("Evil thing #2")

  def addThing(name: String) { things += new Thing(name) }
}

object ClassInAClassExample extends App {
  val p = new PandorasBox
  p.things.foreach { x => println(x) }
}