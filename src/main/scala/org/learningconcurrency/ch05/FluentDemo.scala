package org.learningconcurrency.ch05
import org.learningconcurrency.ch02._
object FluentDemo extends App {
  class Person {
    protected var fname: String = _
    protected var lname: String = _

    def setFirstName(firstName: String): this.type = {
      fname = firstName
      this
    }

    def setLastName(lastName: String): this.type = {
      lname = lastName
      this
    }
  }

  class Employee extends Person {
    protected var role: String = _

    def setRole(role: String): this.type = {
      this.role = role
      this
    }

    override def toString = {
      "%s, %s, %s".format(fname, lname, role)
    }
  }

  val bob = new Employee

  bob.setFirstName("bob").setLastName("Daniel").setRole("Manager")
  log(bob.toString)
}