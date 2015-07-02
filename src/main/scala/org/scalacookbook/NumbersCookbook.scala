package org.scalacookbook

import org.dabao.utils.MathUtils

object NumbersCookbook extends App {
  //toXXX method 
  log(19.35.toInt.toString())
  val a = 1000L
  log(a.isValidByte.toString())

  val a1 = 0.3f
  val b1 = 0.1 + 0.2
  log(s"${a1} = ${b1} is ${MathUtils.~=(a1, b1, 0.00001)}")

  //Generating Random Numbers
  val locale = new java.util.Locale("de", "DE")
  val formatter = java.text.NumberFormat.getIntegerInstance(locale)
  log(formatter.format(10000))
  
  val currencyFormatter = java.text.NumberFormat.getCurrencyInstance(locale)
  log(currencyFormatter.format(123.456789))
  
  import java.util.{Currency, Locale}
  val de = Currency.getInstance(new Locale("de", "DE"))
  currencyFormatter.setCurrency(de)
  log(currencyFormatter.format(123.45678))
  
}