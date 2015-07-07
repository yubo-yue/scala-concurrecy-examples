package org.learningconcurrency.ch06
import org.learningconcurrency.ch02._
class Pizza(var crustType: String) {
  override def toString = s"crust type is $crustType"
}

object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "foo"
}

object PizzaDemo extends App {
  val p = new Pizza(Pizza.CRUST_TYPE_THICK)
  log(p.toString())
}
