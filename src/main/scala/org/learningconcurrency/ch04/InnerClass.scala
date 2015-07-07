package org.learningconcurrency.ch04

object ClassInObject extends App {
  val oc1 = new OuterClass
  val oc2 = new OuterClass
  
  val ic1 = new oc1.InnerClass
  val ic2 = new oc2.InnerClass
  ic1.x = 10
  ic2.x = 20
}

class OuterClass {
  class InnerClass { var x = 1 }
}