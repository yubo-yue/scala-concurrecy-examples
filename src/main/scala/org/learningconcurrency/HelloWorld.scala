package org.learningconcurrency


object HelloWorld extends App {

  log("Hello World")
  def compose[A, B, C](g: B => C, f: A => B): A => C = {
    val h: A => C = (in) => {
      g(f(in))
    }
    h
  }

  def com1(a: Int): Int = a + 1
  def com2(a: Int): Int = a + 2

  val h = compose(com1, com2)
  log(h(3).toString())

  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = {
    (a, b) match {
      case (Some(m), Some(n)) => Some((m, n))
      case (_, _) => None
    }
  }

  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = {
    if (xs.isEmpty) true
    else pred(xs.head) && check(xs.tail)(pred)
  }

  println(check(1 until 40)(40 / _ < 0))

  def permutations(x: String): Seq[String] = {
    permute(x.toList).map(xs => xs.mkString(""))
  }
  def permute(xs: List[Char]): List[List[Char]] = xs match {
    case Nil => List(List())
    case head :: tail => {
      val len = xs.length
      val tps = (0 to len - 1).map(xs.splitAt(_)).toList.filter(tp => !tp._1.contains(tp._2.head))
      tps.map(tp => permute(tp._1 ::: tp._2.tail).map(tp._2.head :: _)).flatten
    }
  }
  
  println(permutations("abcda").mkString("\n"))
}
