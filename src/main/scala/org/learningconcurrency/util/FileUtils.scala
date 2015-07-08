package org.learningconcurrency.util

import java.io.OutputStream
import java.io.InputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.File

object FileUtils {

  /**
   * Loan pattern for managed resource with close method
   */
  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B = {
    try {
      f(resource)
    } finally {
      resource.close()
    }
  }

  def getLinesUppercased(source: io.Source): List[String] = {
    (for (line <- source.getLines()) yield line.toUpperCase()).toList
  }

  def getListOfFiles(dir: String): List[File] = {
    val d = new File(dir)
    if (d.exists() && d.isDirectory()) {
      d.listFiles().filter { x => x.isFile() }.toList
    } else {
      List[File]()
    }
  }

  def getListOfFiles(dir: File, extensions: List[String]): List[File] = {
    dir.listFiles.filter(_.isFile).toList.filter {
      file => extensions.exists(file.getName.endsWith(_))
    }
  }

  def getListOfSubDirectories(dir: File): List[String] = {
    dir.listFiles.filter(_.isDirectory).map(_.getName).toList
  }

  def getListOfSubDirectories2(dir: File): List[String] = {
    val files = dir.listFiles
    val dirs = for {
      file <- files
      if file.isDirectory()
    } yield file.getName

    dirs.toList
  }

}