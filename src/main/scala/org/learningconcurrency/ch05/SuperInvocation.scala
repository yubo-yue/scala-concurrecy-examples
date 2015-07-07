package org.learningconcurrency.ch05
import org.learningconcurrency.ch02._

class FourLeggedAnimal {
  def walk { log("I'm walking") }
  def run { log("I'm running") }
}

class Dog extends FourLeggedAnimal {
  def walkThenRun {
    super.walk
    super.run
  }
}

trait Human {
  def hello = "the Human trait"
}

trait Mother extends Human {
  override def hello = "Mother"
}

trait Father extends Human {
  override def hello = "Father"
}

class Child extends Human with Mother with Father {
  def printSuper = super.hello
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello
}

object SuperInvocationDemo extends App {
  val suka = new Dog
  suka.walkThenRun
  
  val c = new Child
  log(s"c.printSuper: ${c.printSuper}")
  log(s"c.printMother = ${c.printMother}")
  log(s"c.printFather = ${c.printFather}")
  log(s"c.printHuman = ${c.printHuman}")
}