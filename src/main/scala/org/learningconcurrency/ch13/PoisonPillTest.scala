package org.learningconcurrency.ch13

import akka.actor._
import akka.pattern._
import scala.concurrent.{ Await, ExecutionContext, Future }
import scala.language.postfixOps
import scala.concurrent.duration._
import java.util.concurrent.TimeUnit
class TestActor1 extends Actor {
  def receive = {
    case s: String => println("Message received: " + s)
    case _ => println("TestActor1 get an unknow message")
  }

  override def postStop { println("TestActor1::postStop called") }
}

object PoisonPillTest extends App {
  val system = ActorSystem("PoisonPillTest")
  val actor = system.actorOf(Props[TestActor1], name = "test")
  actor ! "before PoisonPill"
  actor ! PoisonPill
  actor ! "after PoisonPill"
  actor ! "hello ?!"

  system.shutdown()
}

class TestActor2 extends Actor {
  def receive = {
    case _ => println("TestActor2 got message")
  }

  override def postStop = { println("TestActor2: postStop") }
}

object GracefulStopTest extends App {
  val system = ActorSystem("GracefulStopTest")
  val testActor = system.actorOf(Props[TestActor2], name = "test2")
  try {
    val stopped: Future[Boolean] = gracefulStop(testActor, FiniteDuration(2, TimeUnit.SECONDS))
    Await.result(stopped, FiniteDuration(2, TimeUnit.SECONDS))
    println("testActor was stopped")
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    system.shutdown()
  }
}