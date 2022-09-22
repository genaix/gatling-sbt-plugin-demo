package perf

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._

object Feeder {
  val myFeed: BatchableFeederBuilder[String] = csv(filePath = "words.csv").eager.random
}
