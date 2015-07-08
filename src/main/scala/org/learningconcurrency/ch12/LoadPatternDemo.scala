package org.learningconcurrency.ch12

object LoadPatternDemo extends App {
  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B = {
    try {
      f(resource)
    } finally {
      resource.close()
    }
  }

  using(io.Source.fromFile("/etc/passwd")) {
    source =>
      {
        for (line <- source.getLines())
          println(line)
      }
  }

  def readTextFile(filename: String): Option[List[String]] = {
    try {
      val lines = using(io.Source.fromFile(filename)) {
        source => (for (line <- source.getLines) yield line).toList
      }
      Some(lines)
    } catch {
      case e: Exception => None
    }
  }
  
  val lines = readTextFile("/etc/passwd")
  lines match  {
    case Some(ls) => ls.foreach(println)
    case None => println("couldn't read file")
  }
}