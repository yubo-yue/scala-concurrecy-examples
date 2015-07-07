package org.learningconcurrency.ch04

import org.learningconcurrency.ch02._

//name and relation default to be val
case class CasePerson(name: String, relation: String)

object CasePersonTest extends App {
  val emily = CasePerson("emily", "niece")
  log(emily.name)
  log(emily.relation)
  
  emily match {
    case CasePerson(n, r) => log(s"$n, $r")
  }
  
  val joe = emily.copy(name="Joe", relation="Mechanic")
  log(joe.toString())
}