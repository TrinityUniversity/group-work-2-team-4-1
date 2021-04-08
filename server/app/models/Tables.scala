package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Person.schema ++ Relationship.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Person
   *  @param userId Database column user_id SqlType(int4), PrimaryKey
   *  @param username Database column username SqlType(varchar), Length(20,true), Default(None)
   *  @param password Database column password SqlType(varchar), Length(20,true), Default(None) */
  case class PersonRow(userId: Int, username: Option[String] = None, password: Option[String] = None)
  /** GetResult implicit for fetching PersonRow objects using plain SQL queries */
  implicit def GetResultPersonRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[PersonRow] = GR{
    prs => import prs._
    PersonRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table person. Objects of this class serve as prototypes for rows in queries. */
  class Person(_tableTag: Tag) extends profile.api.Table[PersonRow](_tableTag, "person") {
    def * = (userId, username, password) <> (PersonRow.tupled, PersonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), username, password)).shaped.<>({r=>import r._; _1.map(_=> PersonRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(int4), PrimaryKey */
    val userId: Rep[Int] = column[Int]("user_id", O.PrimaryKey)
    /** Database column username SqlType(varchar), Length(20,true), Default(None) */
    val username: Rep[Option[String]] = column[Option[String]]("username", O.Length(20,varying=true), O.Default(None))
    /** Database column password SqlType(varchar), Length(20,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(20,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Person */
  lazy val Person = new TableQuery(tag => new Person(tag))

  /** Entity class storing rows of table Relationship
   *  @param relationshipId Database column relationship_id SqlType(serial), AutoInc, PrimaryKey
   *  @param toUser Database column to_user SqlType(int4)
   *  @param fromUser Database column from_user SqlType(int4)
   *  @param `type` Database column type SqlType(int4) */
  case class RelationshipRow(relationshipId: Int, toUser: Int, fromUser: Int, `type`: Int)
  /** GetResult implicit for fetching RelationshipRow objects using plain SQL queries */
  implicit def GetResultRelationshipRow(implicit e0: GR[Int]): GR[RelationshipRow] = GR{
    prs => import prs._
    RelationshipRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table relationship. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class Relationship(_tableTag: Tag) extends profile.api.Table[RelationshipRow](_tableTag, "relationship") {
    def * = (relationshipId, toUser, fromUser, `type`) <> (RelationshipRow.tupled, RelationshipRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(relationshipId), Rep.Some(toUser), Rep.Some(fromUser), Rep.Some(`type`))).shaped.<>({r=>import r._; _1.map(_=> RelationshipRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column relationship_id SqlType(serial), AutoInc, PrimaryKey */
    val relationshipId: Rep[Int] = column[Int]("relationship_id", O.AutoInc, O.PrimaryKey)
    /** Database column to_user SqlType(int4) */
    val toUser: Rep[Int] = column[Int]("to_user")
    /** Database column from_user SqlType(int4) */
    val fromUser: Rep[Int] = column[Int]("from_user")
    /** Database column type SqlType(int4)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("type")

    /** Foreign key referencing Person (database name relationship_from_user_fkey) */
    lazy val personFk1 = foreignKey("relationship_from_user_fkey", fromUser, Person)(r => r.userId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Person (database name relationship_to_user_fkey) */
    lazy val personFk2 = foreignKey("relationship_to_user_fkey", toUser, Person)(r => r.userId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Relationship */
  lazy val Relationship = new TableQuery(tag => new Relationship(tag))
}
