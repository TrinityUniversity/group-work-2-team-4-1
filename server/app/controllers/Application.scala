package controllers

import javax.inject._

import play.api.mvc._
import models.CountingModel

import play.api.libs.json._
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
import actors._
import akka.actor.Props

@Singleton
class Application @Inject()(cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  val manager = system.actorOf(Props[CountingManager], "Manager")

  def index = Action { implicit request =>
    Ok(views.html.index())
  }

  def increment = Action { implicit request =>
    CountingModel.increment()
    Ok(CountingModel.getCount().toString())
  } 

  def incrementSocket = WebSocket.accept[String, String]  { request =>
    ActorFlow.actorRef { out =>
      CountingActor.props(out, manager)
    }
  }
}    
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
         
      
      
      
    