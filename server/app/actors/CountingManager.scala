package actors

import akka.actor.Actor

class CountingManager extends Actor {
private var clients = List.empty[ActorRef]

  import CountingManager._
  def receive = {
    case NewClient(client) => clients ::= client
    case IncrementCount() => {
        CountingModel.increment()
        for (c <- clients) c ! ChatActor.SendMessage(CountingModel.getCount())
    }
    case m => println("Unhandled message in ChatManager: " + m)
  }
}

object CountingManager {
  case class NewChatter(client: ActorRef)
  case class IncrementCount()
}