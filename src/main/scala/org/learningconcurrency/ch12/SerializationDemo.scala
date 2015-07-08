package org.learningconcurrency.ch12

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.FileInputStream
import java.io.ObjectInputStream

@SerialVersionUID(123L)
class Stock(var symbol: String, var price: BigDecimal) extends Serializable {
  override def toString = f"$symbol%s is ${price.toDouble}%.2f"
}

object SerializationDemo extends App {
  
  val nflx = new Stock("NFLX", BigDecimal(85.00))
  println(nflx)
  val oos = new ObjectOutputStream(new FileOutputStream("/tmp/nflx"))
  oos.writeObject(nflx)
  oos.close()
  
  val ois = new ObjectInputStream(new FileInputStream("/tmp/nflx"))
  val stock = ois.readObject().asInstanceOf[Stock]
  ois.close()
  println(stock)
}