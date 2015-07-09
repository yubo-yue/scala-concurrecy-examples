package org.learningconcurrency.ch13

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.{ Await, ExecutionContext, Future }
import scala.concurrent.duration._
import scala.language.postfixOps

case object AskNameMessage
class TestActor3 extends Actor {
  def receive = {
    case AskNameMessage =>
      sender ! "Fred"
    case _ => println("that was unexpected")
  }
}

object AskTest extends App {
  val system = ActorSystem("AskTestSystem")
  val myActor = system.actorOf(Props[TestActor3], name = "myActor")
  
  implicit val timeout = Timeout(5 seconds)
  val future = myActor ? AskNameMessage
  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(result)
  
  val future2: Future[String] = ask(myActor, AskNameMessage).mapTo[String]
  val result2 = Await.result(future2, 1 second)
  println(result2)
  system.shutdown()
}