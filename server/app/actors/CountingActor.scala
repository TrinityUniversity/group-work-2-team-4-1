package actors

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props


class CountingActor(out: ActorRef, manager: ActorRef) extends Actor {
 manager ! CountingManager.NewClient(self)

  import CountingActor._
  def receive = {
    //case s: String => manager ! CountingManager.Message(s)
    case s: String => manager ! CountingManager.IncrementCount() //msg will be count, yeah?
    case SendCount(count) => out ! count
    case m => println("Unhandled message in CountActor: " + m) 
  }
}

object CountingActor {
  def props(out: ActorRef, manager: ActorRef) = Props(new CountingActor(out, manager))

  case class SendCount(count: String)
}