package models

import play.api.libs.json.Json


case class OneMessage(author: String, message: String)

object ReadAndWrites {
    implicit val oneMessageReads = Json.reads[OneMessage]
    implicit val oneMessageWrites = Json.writes[OneMessage]
}