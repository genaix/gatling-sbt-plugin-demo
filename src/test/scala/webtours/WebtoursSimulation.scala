package webtours

import io.gatling.core.Predef._

import scala.concurrent.duration.DurationInt

class WebtoursSimulation extends Simulation {
	setUp(WebtoursScenario.apply()
		.inject(
			rampUsersPerSec(0.1).to(2.8).during(2.minutes),
			constantUsersPerSec(2.8).during(1.hours),
			rampUsersPerSec(2.8).to(0.0).during(2.minutes),
		)
	).protocols(httpProtocol)
}
