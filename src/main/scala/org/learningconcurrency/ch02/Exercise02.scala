package org.learningconcurrency.ch02

object Exercise02 extends App {
  def parallel[A, B](a: => A, b: => B): (A, B) = {
    @volatile var r1 = null.asInstanceOf[A]
    @volatile var r2 = null.asInstanceOf[B]

    val t1 = thread {
      r1 = a
    }
    val t2 = thread {
      r2 = b
    }

    t1.join()
    t2.join()

    (r1, r2)
  }

  def aFunc(): Int = 1
  def bFunc(): Int = 2

  println(parallel(aFunc, bFunc))
}

object Exercise02_2 extends App {
  def periodically(duration: Long)(b: => Unit): Unit = {
    thread {
      while (true) {
        Thread.sleep(duration)
        b
      }
    }
  }

  val run5ms = periodically(5000)(_)
  def p1(): Unit = println("p1")
  def p2(): Unit = println("p2")
  run5ms(p1)
  run5ms(p2)
}