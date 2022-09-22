package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}
class CommonScenario {
  val groupMy: ChainBuilder = group(name = "my group"){
    exec(Actions.getMainPage)
      .exec(Actions.getCompanies)
  }

  val scn: ScenarioBuilder = scenario(name = "my scenario otus")
    .feed(Feeder.myFeed)
    .exec(Actions.getMainPage)
    .exec(Actions.getCompanies)
    .randomSwitch(
      possibilities = 80.0 -> exec(Actions.getJobs),
      20.0 -> exec(Actions.getCompanies),
  )
    .exec(Actions.getSubs)
    .exec(Actions.search)
    .exec(groupMy)
}
