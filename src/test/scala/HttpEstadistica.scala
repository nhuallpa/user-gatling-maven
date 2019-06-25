import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.config.HttpProtocolBuilder.toHttpProtocol
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

import scala.concurrent.duration._

/**
  * Example Gatling load test that sends two HTTP requests to the same URL.
  */
class HttpEstadistica extends Simulation {

  val theHttpProtocolBuilder = http
    .baseURL("http://localhost:8080")

  val theScenarioBuilder = scenario("Estadisticas de personas")
    .exec(
      http("Estadisticas de personas").get("/estadisticas")
    )

  setUp(
    theScenarioBuilder.inject(rampUsers(500).over(60 seconds))
  ).protocols(theHttpProtocolBuilder)
}