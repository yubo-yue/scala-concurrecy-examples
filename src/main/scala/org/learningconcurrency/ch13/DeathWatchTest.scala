package org.learningconcurrency.ch13
import akka.actor._

class Kenny1 extends Actor {
  def receive = {
    case _ => println("Kenny1 received a message")
  }
}

class KennyParent extends Actor {
  val kenny = context.actorOf(Props[Kenny1], name = "kenny2")
  context.watch(kenny)
  
  def receive = {
    case Terminated(kenny) => println("OMG, they killed kenny")
    case _ => println("Parent received a message")
  }
}
object DeathWatchTest extends App {
  val system = ActorSystem("DeathWatchTest")
  val parent =system.actorOf(Props[KennyParent], "kenny_parent")
  
  val kenny = system.actorSelection("/user/kenny_parent/kenny2")
  kenny ! "Message"
  Thread.sleep(5000)
  
  kenny ! PoisonPill
  
  Thread.sleep(5000)
  println("calling system.shutdown")
  system.shutdown()
}