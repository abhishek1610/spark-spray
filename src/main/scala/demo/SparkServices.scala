package demo



import akka.actor.{Actor, ActorContext}
import org.apache.spark.{SparkConf, SparkContext}
import spray.http.HttpResponse
import spray.http.StatusCodes.OK
import spray.routing.Directive.pimpApply
import spray.routing.HttpService

trait SparkService extends HttpService {

  val sparkConf: SparkConf = new SparkConf().setAppName("spark-spray-starter").setMaster("local")
  val sc: SparkContext = new SparkContext(sparkConf)

  val sparkRoutes =
    path("spark" / "version") {
      get {
        complete {
          HttpResponse(OK, "Spark version in this template is: " + sc.version)
        }
      }
    }

}

class SparkServices extends Actor with SparkService {
  def actorRefFactory: ActorContext = context
  def receive: Actor.Receive = runRoute(sparkRoutes)
}
