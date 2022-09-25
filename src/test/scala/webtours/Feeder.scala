package webtours

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder

object Feeder {
  val credentialsFeed: BatchableFeederBuilder[String] = ssv(filePath = "webtours_credentials.csv").eager.random
}
