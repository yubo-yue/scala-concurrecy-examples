package org.learningconcurrency.ch04
import org.learningconcurrency.ch02._
class Person(var firstName: String, var lastName: String) {
  log("the constructor begins")

  private val HOME = System.getProperty("user.home")
  var age = 0

  override def toString(): String = s"$firstName $lastName is $age years old"

  def printHome { log(s"Home = $HOME") }

  def printFullName { log(this.toString()) }

  printHome
  printFullName
  log("still in the constructor")

  def canEqual(a: Any) = a.isInstanceOf[Person]
  override def equals(that: Any): Boolean =
    that match {
      case that: Person => that.canEqual(this) && this.hashCode() == that.hashCode()
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + lastName.hashCode()
    result = prime * result + firstName.hashCode()
    return result
  }
}

object Person extends App {
  val p = new Person("Adam", "Meyer")
  p.firstName = "yubo"
  p.firstName_$eq("yo")

  log(p.toString())
}
