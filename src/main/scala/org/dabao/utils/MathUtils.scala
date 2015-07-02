package org.dabao.utils

object MathUtils extends App {
  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }
}