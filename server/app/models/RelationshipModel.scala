package models

import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future

class RelationshipModel(db: Database)(implicit ec: ExecutionContext) {

    def getUsers(): Future[Seq[User]] = {
        db.run(
            (for {
                user <- Person
                } yield {
                user
            }).result
        ).map(users => users.map(user => User(user.username.get, user.password.get)))
    }
}

case class User(username: String, password: String)