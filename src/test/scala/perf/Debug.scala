package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Debug extends Simulation{
  setUp(
    CommonScenario().inject(atOnceUsers(users = 1))
  )
    .protocols(httpProtocol)
    .maxDuration(10)
    .assertions(global.responseTime.max.lt(1000))
}
