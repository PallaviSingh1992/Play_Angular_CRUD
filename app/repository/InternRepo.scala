package repository

import javax.xml.soap.Detail
import com.google.inject.{Inject, ImplementedBy}
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile
import scala.concurrent.Future


case class Interns(id:Int,name:String,email:String,mobile:String,address:String,emergency:String)

trait InternTable{ self: HasDatabaseConfigProvider[JdbcProfile] =>
  import driver.api._

  class InternTable(tag:Tag) extends Table[Interns](tag,"interns") {
    val id=column[Int]("id",O.AutoInc,O.PrimaryKey)
    val name= column[String]("name", O.SqlType("VARCHAR(200)"))
    val email= column[String]("email", O.SqlType("VARCHAR(200)"))
    val mobile= column[String]("mobile", O.SqlType("VARCHAR(200)"))
    val address= column[String]("address", O.SqlType("VARCHAR(200)"))
    val emergency= column[String]("emergency", O.SqlType("VARCHAR(200)"))

    def * = (id, name,email,mobile,address,emergency) <> (Interns.tupled,Interns.unapply)
  }

  val tableQuery = TableQuery[InternTable]
}

class InternRepo @Inject()(protected val dbConfigProvider:DatabaseConfigProvider) extends InternTable with HasDatabaseConfigProvider[JdbcProfile]{
  import driver.api._
  def getAll():Future[List[Interns]]=db.run{ tableQuery.to[List].result}

  def insert(intern:Interns):Future[Int]=db.run{
    println(intern)
  	tableQuery+=intern}
  def delete(id:Int):Future[Int]=db.run{tableQuery.filter(_.id===id).delete}
  def update(intern:Interns):Future[Int]=db.run{tableQuery.filter(_.id===intern.id).update(intern)}
  def getById(id:Int):Future[Interns]=db.run{tableQuery.filter(_.id===id).result.head}
}