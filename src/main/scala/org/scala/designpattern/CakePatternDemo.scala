package org.scala.designpattern

trait Context

trait Config {
  load
  def load: Unit
  val text: String
}

case class InMemoryConfig() extends Config {
  lazy val text = "hello"
  def load = println(s"load: $text")
}

case class Session(context: {val config: Config}) {
  def text = context.config.text
}

object MyContext extends Context {
  lazy val config = InMemoryConfig()
}

object CakePatternDemo extends App {
  val session = Session(MyContext)
  println(session.text)
}