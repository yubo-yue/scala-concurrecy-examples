package org.learningconcurrency

package object ch06 {
  val MAGIC_NUM = 42
  def echo(a: Any) { println(a) }
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }

  //type definition
  type MutableMap[K, V] = scala.collection.mutable.Map[K, V]
  val MutableMap = scala.collection.mutable.Map
}