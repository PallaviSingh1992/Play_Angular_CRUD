package controllers

import javax.inject._
import play.api._
import play.api.libs.json.{Writes, JsPath, Reads, Json}
import play.api.mvc._
import repository.InternRepo
import scala.concurrent.ExecutionContext.Implicits.global
import repository.Interns
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(service:InternRepo) extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  implicit val internReads: Writes[Interns] = (
    (JsPath \ "id").write[Int] and
      (JsPath \ "name").write[String] and
      (JsPath \"email").write[String] and
      (JsPath \ "mobile").write[String] and
      (JsPath \ "address").write[String] and
      (JsPath \ "emergency").write[String] )(unlift(Interns.unapply))

  def index = Action {
    Ok(views.html.index("Your new application is Ready."))
  }

  def list = Action.async { implicit request =>
    val list = service.getAll()
    list.map{intern => {
     Ok(Json.toJson(intern))
    }}
    }

  def showList = Action{

    Ok(views.html.interns())
  }



  }


