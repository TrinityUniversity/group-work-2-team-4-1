


import org.scalajs.dom
import org.scalajs.dom.document
import scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.html


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
}
