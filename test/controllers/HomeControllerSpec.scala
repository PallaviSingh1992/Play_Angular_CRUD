package controllers

import org.mockito.Mockito._
import org.specs2.mock.Mockito
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.core.routing.Route
import repository.{Interns, InternRepo}
import scala.concurrent.Future

@RunWith(classOf[JUnitRunner])
class HomeControllerSpec extends PlaySpecification with Mockito {

  "Home Controller" should {

    val service=mock[InternRepo]
    val controller=new HomeController(service)

    "get index" in new WithApplication() {

        val home = route(app, FakeRequest(GET, "/")).get

        status(home) must equalTo(OK)
    }

    "list all records" in new WithApplication() {

      when(service.getAll()).thenReturn(Future(List(Interns(1,"himani","himani@knoldus.in","898009800","delhi","22469890"))))

      val res=call(controller.list,FakeRequest(GET,"/list"))

      status(res) must equalTo(OK)
    }

    "list records by id" in new WithApplication() {

      when(service.getById(1)).thenReturn(Future(Interns(1,"himani","himani@knoldus.in","898009800","delhi","22469890")))
      val res=call(controller.getById(1),FakeRequest(GET,"/edit/1"))
      status(res) must equalTo(OK)
    }

    "show list" in new WithApplication() {

      val res=call(controller.showList,FakeRequest(GET,"/showlist"))
      status(res) must equalTo(OK)
    }

    "add a record" in new WithApplication() {

      when(service.insert(Interns(1,"himani","himani@knoldus.in","898009800","delhi","22469890"))).thenReturn(Future(1))
      val res=call(controller.insert,FakeRequest(POST,"/insert").withFormUrlEncodedBody("id"->"1","name"->"himani","email"->"himani@knoldus.in","mobile"->"898009800","address"->"delhi","emergency"->"22469890"))
      status(res) must equalTo(OK)
    }

    "show add" in new WithApplication() {

      val res=call(controller.showAdd,FakeRequest(GET,"/add"))
      status(res) must equalTo(OK)
    }

    "update a record" in new WithApplication() {

      when(service.update(Interns(1,"himani","himani@knoldus.in","898009800","delhi","22469890"))).thenReturn(Future(1))
      val res=call(controller.update(1),FakeRequest(POST,"/update").withFormUrlEncodedBody("id"->"1","name"->"himani","email"->"himani@knoldus.in","mobile"->"898009800","address"->"delhi","emergency"->"22469890"))
      status(res) must equalTo(SEE_OTHER)
    }

    "delete a record" in new WithApplication() {

      when(service.delete(1)).thenReturn(Future(1))
      val res=call(controller.delete(1),FakeRequest(GET,"/delete/1"))
      status(res) must equalTo(OK)
    }

  }

}
