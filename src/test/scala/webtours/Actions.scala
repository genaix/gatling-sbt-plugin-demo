package webtours

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder


object Actions {

  private val headers_0 = Map(
    "Upgrade-Insecure-Requests" -> "1",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
  )

  private val headers_1 = Map(
    "Accept" -> "image/avif,image/webp,*/*",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
  )

  private val headers_2 = Map(
    "Origin" -> urlAdderss,
    "Upgrade-Insecure-Requests" -> "1"
  )

  val openLoginPage: HttpRequestBuilder = http("openLoginPage")
    .get("/webtours/")
    .headers(headers_0)
    .check(status is 200)

  val loginPageHeader: HttpRequestBuilder = http("loginPageHeader")
    .get("/webtours/header.html")
    .headers(headers_0)
    .check(status is 200)

  val loginPageWelcomePl: HttpRequestBuilder = http("loginPageWelcomePl")
    .get("/cgi-bin/welcome.pl?signOff=true")
    .headers(headers_0)
    .check(status is 200)

  val loginPageLogo: HttpRequestBuilder = http("loginPageLogo")
    .get("/webtours/images/hp_logo.png")
    .headers(headers_1)
    .check(status is 200)

  val loginPageWebtours: HttpRequestBuilder = http("loginPageWebtours")
    .get("/webtours/images/webtours.png")
    .headers(headers_1)
    .check(status is 200)

  val loginPageNavPlHome: HttpRequestBuilder = http("loginPageNavPlHome")
    .get("/cgi-bin/nav.pl?in=home")
    .headers(headers_0)
    .check(css("input[name=\"userSession\"]", "value").find.exists.saveAs("userSession"))
    .check(status is 200)

  val loginPageHome: HttpRequestBuilder = http("loginPageHome")
    .get("/WebTours/home.html")
    .headers(headers_0)
    .check(status is 200)

  val loginPageLogin: HttpRequestBuilder = http("loginPageLogin")
    .get("/WebTours/images/mer_login.gif")
    .headers(headers_1)
    .check(status is 200)

  val doLogin: HttpRequestBuilder = http("doLogin")
    .post("/cgi-bin/login.pl")
    .headers(headers_2)
    .formParam("userSession", "#{userSession}")
    .formParam("username", "#{login}")
    .formParam("password", "#{password}")
    .formParam("login.x", "0")
    .formParam("login.y", "0")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)

  val doLoginNavPlMenuHome: HttpRequestBuilder = http("doLoginNavPlMenuHome")
    .get("/cgi-bin/nav.pl?page=menu&in=home")
    .headers(headers_0)
    .check(status is 200)

  val doLoginLoginPl: HttpRequestBuilder = http("doLoginLoginPl")
    .get("/cgi-bin/login.pl?intro=true")
    .headers(headers_0)
    .check(status is 200)

  val doLoginFlights: HttpRequestBuilder = http("doLoginFlights")
    .get("/WebTours/images/flights.gif")
    .headers(headers_1)
    .check(status is 200)

  val doLoginItinerary: HttpRequestBuilder = http("doLoginItinerary")
    .get("/WebTours/images/itinerary.gif")
    .headers(headers_1)
    .check(status is 200)

  val doLoginSignoff: HttpRequestBuilder = http("doLoginSignoff")
    .get("/WebTours/images/signoff.gif")
    .headers(headers_1)
    .check(status is 200)

  val doLoginInHome: HttpRequestBuilder = http("doLoginInHome")
    .get("/WebTours/images/in_home.gif")
    .headers(headers_1)
    .check(status is 200)

  val openFlights: HttpRequestBuilder = http("openFlights")
    .get("/cgi-bin/welcome.pl?page=search")
    .headers(headers_0)
    .check(status is 200)

  val openFlightsNavPlMenuFlights: HttpRequestBuilder = http("openFlightsNavPlMenuFlights")
    .get("/cgi-bin/nav.pl?page=menu&in=flights")
    .headers(headers_0)
    .check(status is 200)

  val openFlightsInFlights: HttpRequestBuilder = http("openFlightsInFlights")
    .get("/WebTours/images/in_flights.gif")
    .headers(headers_1)
    .check(status is 200)

  val openFlightsReservationsPlWelcome: HttpRequestBuilder = http("openFlightsReservationsPlWelcome")
    .get("/cgi-bin/reservations.pl?page=welcome")
    .headers(headers_0)
    .check(status is 200)
    .check(css("select[name=\"depart\"] option", "value")
      .findAll.exists.saveAs("departures"))
    .check(css("select[name=\"arrive\"] option", "value")
      .findAll.exists.saveAs("arrivals"))

  val openFlightsHome: HttpRequestBuilder = http("openFlightsHome")
    .get("/WebTours/images/home.gif")
    .headers(headers_1)
    .check(status is 200)

  val openFlightsButtonNext: HttpRequestBuilder = http("openFlightsButtonNext")
    .get("/WebTours/images/button_next.gif")
    .headers(headers_1)
    .check(status is 200)

  val findFlight: HttpRequestBuilder = http("findFlight")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_2)
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{departures.random()}")
    .formParam("departDate", DateTimeCalculated.departureDate)
    .formParam("arrive", "#{arrivals.random()}")
    .formParam("returnDate", DateTimeCalculated.returnDate)
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "47")
    .formParam("findFlights.y", "8")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status is 200)
    .check(css("input[name=\"outboundFlight\"]", "value")
      .findAll.exists.saveAs("airplanes"))

  val chooseAirplane: HttpRequestBuilder = http("chooseAirplane")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_2)
    .formParam("outboundFlight", "#{airplanes.random()}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "76")
    .formParam("reserveFlights.y", "7")
    .check(status is 200)

  val paymentDetails: HttpRequestBuilder = http("paymentDetails")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_2)
    .formParam("firstName", "#{login}")
    .formParam("lastName", "#{login}")
    .formParam("address1", "")
    .formParam("address2", "")
    .formParam("pass1", "#{login} #{login}")
    .formParam("creditCard", "")
    .formParam("expDate", "")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "#{airplanes.random()}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "22")
    .formParam("buyFlights.y", "5")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)

  val backToRoot: HttpRequestBuilder = http("backToRoot")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_2)
    .formParam("Book Another.x", "60")
    .formParam("Book Another.y", "6")
    .check(status is 200)
}
