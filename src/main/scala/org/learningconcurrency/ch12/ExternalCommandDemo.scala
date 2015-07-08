package org.learningconcurrency.ch12

import sys.process._
import java.io.File
object ExternalCommandDemo extends App {
  val output = Process("ls -al", new File("/tmp")).!!
  println(output)
}