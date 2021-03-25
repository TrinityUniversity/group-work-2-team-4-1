package actors

import akka.actor.Actor
import akka.actor.ActorRef
import models.CountingModel

class CountingManager extends Actor {
private var clients = List.empty[ActorRef]

  import CountingManager._
  def receive = {
    case NewClient(client) => clients ::= client
    case IncrementCount() => {
        CountingModel.increment()
        for (c <- clients) c ! CountingActor.SendCount(CountingModel.getCount().toString())
    }
    case m => println("Unhandled message in CountManager: " + m)
  }
}

object CountingManager {
  case class NewClient(client: ActorRef)
  case class IncrementCount()
}