import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

package object perf {
  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(url = "https://vc.ru")
    .acceptHeader(value = "text/html")
}
