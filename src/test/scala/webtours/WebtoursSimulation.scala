package webtours

import io.gatling.core.Predef._

class WebtoursSimulation extends Simulation {
	setUp(WebtoursScenario.apply()
		.inject(
			constantUsersPerSec(0.4).during(120),
			constantUsersPerSec(0.8).during(120),
			constantUsersPerSec(1.2).during(120),
			constantUsersPerSec(1.6).during(120),
			constantUsersPerSec(2.0).during(120),
			constantUsersPerSec(2.4).during(120),
			constantUsersPerSec(2.8).during(120),
			constantUsersPerSec(3.2).during(120),
			constantUsersPerSec(3.6).during(120),
			constantUsersPerSec(4.0).during(120),
		)
	).protocols(httpProtocol)
}
