package org.learningconcurrency.ch13

import akka.actor._

case class CreateChild(name: String)
case class Name(name: String)

class Child extends Actor {
  var name = "No name"
  override def postStop {
    println(s"D'oh! They killed me ($name): ${self.path}")
  }
  
  def receive = {
    case Name(name) => this.name = name
    case _ => println("Child $name got message")
  }
}

class Parent extends Actor {
  def receive = {
    case CreateChild(name) =>
      println(s"parent about to create Child ($name) ...")
      val child = context.actorOf(Props[Child], name = s"$name") 
      child ! Name(name)
    case _ => println(s"Parent got some of other message")
  }
}

object ParentChildDemo extends App {
  val actorSystem = ActorSystem("ParentChildDemo")
  val parent = actorSystem.actorOf(Props[Parent], name ="Parent")
  
  parent ! CreateChild("Jonathan")
  parent ! CreateChild("Jordan")
  
  Thread.sleep(5000)
  println("Sending jonathan a PoisonPill ...")
  val jonathan = actorSystem.actorSelection("/user/Parent/Jonathan")
  jonathan ! PoisonPill
  println("jonathan was killed")
  
  Thread.sleep(5000)
  actorSystem.shutdown()
}