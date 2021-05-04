package playscala

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html._
import org.scalajs.dom.document
import org.scalajs.dom.html

@react class ButtonComponent extends Component {
  type Props = Unit
  case class State(count: Int, author: String, message: String)

  def initialState: State = State(0, "", "")


  def render(): ReactElement = div (
      "Slinky",
      button (state.count,  onClick := (e => increment())),
      h3 ("New Author"),
      input (`type` := "text", value := state.author),
      br(),
      h3 ("New Message"),
      input (`type` := "text", value := state.message),
      br(),
      button (`type` := "submit", value := "Send", onClick := (e => sendMessage()))
  )

  def increment(): Unit = {
      setState(state.copy(count = state.count + 1))
  }

  def sendMessage(): Unit = {
// val author = document.getElementById("message-author").asInstanceOf[html.Input].value
//     val message = document.getElementById("message-route").asInstanceOf[html.Input].value
//     val data = OneMessage(author, message)
//     println(author)
//     println(message)
//     println(data)
//     fetch(messageRoute, data, (bool: Boolean) => {
//       if(bool) {
//         println("true")
//         document.getElementById("messageAuthor").asInstanceOf[html.Input].value = author
//         document.getElementById("messageMessage").asInstanceOf[html.Input].value = message
//       } else {
//         println("false")
//         document.getElementById("messageAuthor").innerHTML = "Message Update Failed"
//       }
//     }, e => {
//       println("Fetch error: " + e)
//     })
  }
}