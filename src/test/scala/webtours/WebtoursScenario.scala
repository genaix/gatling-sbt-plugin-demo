package webtours

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

object WebtoursScenario {
  def apply(): ScenarioBuilder = new WebtoursScenario().scn
}
class WebtoursScenario {
  val openLoginPageGroup: ChainBuilder = group(name = "openLoginPageGroup"){
    exec(Actions.openLoginPage)
      .exec(Actions.loginPageHeader)
      .exec(Actions.loginPageWelcomePl)
      .exec(Actions.loginPageLogo)
      .exec(Actions.loginPageWebtours)
      .exec(Actions.loginPageNavPlHome)
      .exec(Actions.loginPageHome)
      .exec(Actions.loginPageLogin)
  }

  val doLoginGroup: ChainBuilder = group(name = "doLoginGroup"){
    exec(Actions.doLogin)
      .exec(Actions.doLoginNavPlMenuHome)
      .exec(Actions.doLoginLoginPl)
      .exec(Actions.doLoginFlights)
      .exec(Actions.doLoginItinerary)
      .exec(Actions.doLoginSignoff)
      .exec(Actions.doLoginInHome)
  }

  val openFlightsGroup: ChainBuilder = group(name = "openFlightsGroup"){
    exec(Actions.openFlights)
      .exec(Actions.openFlightsNavPlMenuFlights)
      .exec(Actions.openFlightsInFlights)
      .exec(Actions.openFlightsReservationsPlWelcome)
      .exec(Actions.openFlightsHome)
      .exec(Actions.openFlightsButtonNext)
  }

  val scn: ScenarioBuilder = scenario(name = "my scenario otus")
    .feed(Feeder.credentialsFeed)
    .exec(openLoginPageGroup)
    .exec(doLoginGroup)
    .exec(openFlightsGroup)
    .exec(Actions.findFlight)
    .exec(Actions.chooseAirplane)
    .exec(Actions.paymentDetails)
    .exec(Actions.backToRoot)
}
