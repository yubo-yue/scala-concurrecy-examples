package org.learningconcurrency.ch05

import java.io.IOException
import javax.sound.sampled.UnsupportedAudioFileException

object MethodThrowExceptionDemo extends App {

  @throws(classOf[Exception])
  def play {}
  
  @throws(classOf[IOException])
  @throws(classOf[UnsupportedAudioFileException])
  def playSound {}
  
  def boom {
    throw new Exception
  }
  boom
}