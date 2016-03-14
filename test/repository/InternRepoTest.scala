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
  }

}
