package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.libs.json._
import models._

import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.ExecutionContext
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future

@Singleton
class Relationship @Inject() (protected val dbConfigProvider: DatabaseConfigProvider, cc: ControllerComponents)(implicit ec: ExecutionContext) 
    extends AbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {
  
  private val model = new RelationshipModel(db)

  def load = Action { implicit request =>
    Ok(views.html.relationship())
  }

  //implicit val userDataReads = Json.reads[UserData]
  implicit val taskItemWrites = Json.writes[User]

//   def withJsonBody[A](f: A => Future[Result])(implicit request: Request[AnyContent], reads: Reads[A]): Future[Result] = {
//     request.body.asJson.map { body =>
//       Json.fromJson[A](body) match {
//         case JsSuccess(a, path) => f(a)
//         case e @ JsError(_) => Future.successful(Redirect(routes.TaskList3.load()))
//       }
//     }.getOrElse(Future.successful(Redirect(routes.TaskList3.load())))
//   }

  def users = Action.async { implicit request =>
    model.getUsers.map(user => Ok(Json.toJson(user)))
  }

//   def addTask = Action.async { implicit request =>
//     withSessionUserid { userid =>
//       withJsonBody[String] { task =>
//         model.addTask(userid, task).map(count => Ok(Json.toJson(count > 0)))
//       }
//     }
//   }

//   def delete = Action.async { implicit request =>
//     withSessionUsername { username =>
//       withJsonBody[Int] { itemId =>
//         model.removeTask(itemId).map(removed => Ok(Json.toJson(removed)))
//       }
//     }
//   }


}