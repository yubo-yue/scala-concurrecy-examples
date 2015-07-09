package org.scala.designpattern

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) {buf += x}
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(x * 2)}
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {super.put(x + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) { if (x >= 0) super.put(x) }
}

object StackableTraitDemo extends App {
  val queue = new BasicIntQueue with Incrementing with Doubling
  queue.put(10)
  println(queue.get())
}