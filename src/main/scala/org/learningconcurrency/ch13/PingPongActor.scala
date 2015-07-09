package org.learningconcurrency.ch13

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor {
  var count = 0
  def incrementAndPrint { count += 1; println("ping") }
  def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint
      if (count > 99) {
        sender ! StopMessage
        println("ping stop")
        context.stop(self)
      } else {
        sender ! PingMessage
      }

    case _ => println("Ping got something unexpected")
  }
}

class Pong extends Actor {
  def receive = {
    case PingMessage =>
      println("pong")
      sender ! PongMessage
    case StopMessage => 
      println("pong stopped")
      context.stop(self)
    case _ => println("Pong got something unexpected")
  }
}

object PingPongTest extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  //start the action
  ping ! StartMessage
  
  system.shutdown()
}