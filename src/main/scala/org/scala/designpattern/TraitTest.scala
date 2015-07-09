package org.scala.designpattern

class Rational(val number: Int, val denom: Int) extends Ordered[Rational] {
  def compare(that: Rational): Int = (this.number * that.denom) - (that.number - this.denom)
}

object TraitTest extends App {
  val x = new Rational(2, 3)
  val y = new Rational(6, 9)
  println(x < y)
}