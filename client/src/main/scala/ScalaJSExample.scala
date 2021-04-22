

import org.scalajs.dom
import org.scalajs.dom.document
import scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.html
import models

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    // dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    for(x <- 1 to 10) println(x)


  }

  @JSExportTopLevel("doClickStuff")
  def increment(): Unit = {
    val button = document.getElementById("countbutton").asInstanceOf[html.Button]
    var count = button.innerHTML.toInt
    count += 1
    button.innerHTML = count.toString
  }
 val csrfToken = document.getElementById("csrfToken").asInstanceOf[html.Input].value
 val messageRoute = document.getElementById("messageRoute").asInstanceOf[html.Input].value

 @JSExportTopLevel("updateMessage")
  def updateMessage(): Unit = {
    val author = document.getElementById("messageAuthor").asInstanceOf[html.Input].value
    val message = document.getElementById("messageMessage").asInstanceOf[html.Input].value
    val data = models.OneMessage(author, message)
    fetch(messageRoute, csrfToken, data, (bool: Boolean) => {
      if(bool) {
        document.getElementById("messageAuthor").asInstanceOf[html.Input].value = author
        document.getElementById("messageMessage").asInstanceOf[html.Input].value = message
      } else {
        document.getElementById("messageAuthor").innerHTML = "Message Update Failed"
      }
    }, e => {
      println("Fetch error: " + e)
    })
  }


  implicit val ec = ExecutionContext.global

  def fetch[A, B](url: String, data: A, success: B => Unit, error: JsError => Unit)(implicit writes: Writes[A], reads: Reads[B]): Unit = {
    val hs = new Headers()
    hs.set("Content-Type", "application/json")
    hs.set("Csrf-Token", dom.document.getElementsByTagName("body").apply(0).getAttribute("data-token"))
    Fetch.fetch(
      url,
      new RequestInit {
        method = HttpMethod.POST
        headers = hs
        body = Json.toJson(data).toString
      }
    ).flatMap(_.text()).map { res =>
      Json.fromJson[B](Json.parse(res)) match {
        case JsSuccess(ret, path) => 
          success(ret)
        case e @ JsError(_) => 
          println("Fetch error " + e)
          error(e)
      }
    }
  }
}
