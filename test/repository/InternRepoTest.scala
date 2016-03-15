package repository

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.Application
import play.api.test.WithApplication
import scala.concurrent.Await
import scala.concurrent.duration.Duration

@RunWith(classOf[JUnitRunner])
class InternRepoTest extends Specification {

  def internRepo(implicit app:Application)=Application.instanceCache[InternRepo].apply(app)

  "Intern Repo" should {

    "get record" in new WithApplication() {
      val res = internRepo.getAll()
      val response = Await.result(res, Duration.Inf)
      response.head.id ===1
    }

    "add record" in new WithApplication() {
      val res=internRepo.insert(Interns(4,"Prabhat","prabhat@knoldus.in","9988111000","Moti Bagh","9988877711"))
      val response=Await.result(res,Duration.Inf)
      response===1
    }

    "update record" in new WithApplication() {
      val res=internRepo.update(Interns(1,"himani","himani@knoldus.in","889934657","delhi","22569090"))
      val response=Await.result(res,Duration.Inf)
      response===1
    }

    "delete record" in new WithApplication() {
      val res=internRepo.delete(1)
      val response=Await.result(res,Duration.Inf)
      response===1
    }

    "get records by id" in new WithApplication() {
      val res=internRepo.getById(1)
      val response=Await.result(res,Duration.Inf)
      response.id===1
    }
  }

}
