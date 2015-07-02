package org.learningconcurrency.ch03

import scala.annotation.switch

object SwitchDemo extends App {
  val i = 1
  
  val x = i match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Other"
  }
}