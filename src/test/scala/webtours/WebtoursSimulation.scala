package webtours

import io.gatling.core.Predef._

class WebtoursSimulation extends Simulation {
	setUp(WebtoursScenario.apply()
		.inject(
			incrementUsersPerSec(1.5)
				.times(10)
				.eachLevelLasting(60)
				.separatedByRampsLasting(1)
				.startingFrom(1.5) // Double
		)
	).protocols(httpProtocol)
}
