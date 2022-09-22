package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {
  val getMainPage: HttpRequestBuilder = http(requestName = "open main page")
    .get("/")
    .check(status is 200)

  val getCompanies: HttpRequestBuilder = http(requestName = "open Companies")
    .get("/companies")
    .queryParam(name = "mode", value = "ajax")
    .check(status is 200)

  val getJobs: HttpRequestBuilder = http(requestName = "open Job")
    .get("/job")
    .queryParam(name = "mode", value = "ajax")
    .check(status not 500)

  val search: HttpRequestBuilder = http(requestName = "search")
    .get("/search/v2/content/relevant")
    .queryParamMap(map = Map(("mode", "ajax"), ("query", "#{word}")))  // variable substitute name as first row in csv
    .check(regex("""content-feed""").exists)

  val getSubs: HttpRequestBuilder = http(requestName = "open Subs")
    .get("/subs")
    .queryParam(name = "mode", value = "ajax")
    .check(regex("""Ещё (\d+)&nbsp;подписки""").exists.saveAs(key = "subsNumber"))
    .check(status is 200)
}
