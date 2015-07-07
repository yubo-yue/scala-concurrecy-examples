import org.learningconcurrency.ch04.Person
import org.scalatest.FunSuite


class PersonTests extends FunSuite{
  val nimoy = new Person("Nimoy", "Deng")
  val nimoy2 = new Person("Nimoy", "Deng")
  
  test("nimoy == nimoy2") {
    assert(nimoy == nimoy2)
  }
  
}