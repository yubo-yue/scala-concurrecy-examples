package org.learningconcurrency.ch04

import org.learningconcurrency.ch02._

class Brain private {
  override def toString = "This is the brain"
}

object Brain {
  val brain = new Brain
 def getInstance = brain
}

object SingletonTest extends App {
  val brain = Brain.getInstance
  log(brain.toString())
}