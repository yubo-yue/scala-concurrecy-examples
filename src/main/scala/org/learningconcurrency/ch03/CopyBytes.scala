package org.learningconcurrency.ch03

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

object CopyBytes extends App {

  var in = None: Option[FileInputStream]
  var out = None: Option[FileOutputStream]

  try {
    in = Some(new FileInputStream("/tmp/test.txt"))
    out = Some(new FileOutputStream("/tmp/test.txt.copy"))
    var c = 0
    while ({ c = in.get.read; c != -1 }) {
      out.get.write(c)
    }
  } catch {
    case e: IOException => e.printStackTrace()
  } finally {
    println("entered finally ...")
    if (in.isDefined) in.get.close
    if (out.isDefined) out.get.close
  }
}