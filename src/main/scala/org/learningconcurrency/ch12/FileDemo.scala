package org.learningconcurrency.ch12
import org.learningconcurrency.util._
import java.io.File
object FileDemo extends App {
  val files = FileUtils.getListOfFiles("/tmp")
  files.filter(_.getName.startsWith("s")).foreach(x => println(x.getAbsolutePath))
  
  val okFileExtension = List("wav", "so")
  val result = FileUtils.getListOfFiles(new File("/tmp"), okFileExtension)
  result.foreach(println)
  
  FileUtils.getListOfSubDirectories(new File("/home/yubo")).foreach(println(_))
}