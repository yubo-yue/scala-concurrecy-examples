package org.learningconcurrency.ch12

import scala.io.Source

object ScalaIOFileDemo extends App {
  
  val whereami = System.getProperty("user.dir")
  println(whereami)
  
  val PATH = getClass.getResource("").getPath
  println(PATH)
  val filename =  "build.sbt"
  println(filename)
  for (line <- Source.fromFile(filename).getLines)
    println(line)
    
    
  for (line <- io.Source.fromFile("/etc/passwd").getLines())
    println(line)
    
  val contents = io.Source.fromFile("/etc/passwd").mkString
  println(contents)
}