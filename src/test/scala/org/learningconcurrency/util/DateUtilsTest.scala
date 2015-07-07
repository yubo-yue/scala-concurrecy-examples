package org.learningconcurrency.util

import org.scalatest.FunSuite

class DateUtilsTest extends FunSuite {
  test("Not null" ) {
    println(DateUtils.getCurrentTime)
    assert(DateUtils.getCurrentDate != null)
  }
}