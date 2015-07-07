package org.learningconcurrency.util

import java.text.SimpleDateFormat
import java.util.Calendar

object DateUtils {
  def getCurrentTime: String = getCurrentDateTime("K:m aa")
  
  def getCurrentDate: String = getCurrentDateTime("EEEE, MMMM d")
  
  private def getCurrentDateTime(dateTimeFormat: String): String = {
    val dateFormat = new SimpleDateFormat(dateTimeFormat)
    val cal = Calendar.getInstance
    dateFormat.format(cal.getTime)
  }
}