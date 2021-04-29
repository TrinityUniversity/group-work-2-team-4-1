package controllers
import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.libs.json._
import models._

class Messages @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

    val author = "default author"
    val message = "default message"

    def load = Action { implicit request =>
    // handle form data and update
    // request.data
    println(request)
    Ok(views.html.message())
  }
  def index=Action{implicit request=>
    Ok(views.html.message())
}


}