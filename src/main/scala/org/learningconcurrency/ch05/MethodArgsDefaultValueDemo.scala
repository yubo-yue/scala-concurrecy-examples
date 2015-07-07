package org.learningconcurrency.ch05
import org.learningconcurrency.ch02._

class Connection {
  def makeConnection(timeout: Int = 5000, protocol: String = "Http") {
    log("timeout = %d, protocol = %s".format(timeout, protocol))
  }
}

object MethodArgsDefaultValueDemo extends App {
  val c = new Connection
  c.makeConnection(1000, "ftp")
  c.makeConnection(2000)
  c.makeConnection()
  c.makeConnection(protocol = "https")
}

class Pizza {
  def crustSize = 12
}

object MethodReturnMutlipleDemo extends App {
  def getStockInfo =
    ("NFLX", 100.00, 101.00)

  val (symbol, currentPrice, bidPrice) = getStockInfo

  log(s"symbol = $symbol, currentPrice = $currentPrice, bidPrice = $bidPrice")

  
  def printAll(strings: String *) {
    strings.foreach { x => log(x) }
  }
  
  printAll("Hello", "World", "Yubo")
}