package com.facturacion.loadtest

import scala.concurrent.duration.DurationInt

import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef.StringBody
import io.gatling.core.Predef.checkBuilder2Check
import io.gatling.core.Predef.configuration
import io.gatling.core.Predef.defaultJsonParsers
import io.gatling.core.Predef.defaultJsonPathExtractorFactory
import io.gatling.core.Predef.findCheckBuilder2CheckBuilder
import io.gatling.core.Predef.findCheckBuilder2ValidatorCheckBuilder
import io.gatling.core.Predef.rampUsersPerSec
import io.gatling.core.Predef.scenario
import io.gatling.core.Predef.stringToExpression
import io.gatling.core.Predef.value2Expression
import io.gatling.http.Predef.http
import io.gatling.http.Predef.jsonPath
import io.gatling.http.Predef.status
import io.gatling.http.protocol.HttpProtocolBuilder.toHttpProtocol
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder
import org.springframework.web.client.RestTemplate
import scala.reflect.ClassTag

class ListingTest extends Simulation {

  val baseUrl = "http://localhost:8080/facturacion/api"

  val restTemplate = new RestTemplate();
  try {
    restTemplate.headForHeaders(baseUrl)
  } catch {
    case _: Throwable => {
      println("Server not up")
      System.exit(0)
    }
  }

  val httpConf = http.baseURL(baseUrl)

  val scn = scenario("ListColores")
    .exec(http("request_auth")
      .post("/auth")
      .body(StringBody("{\"id\": null, \"username\": \"testUsername\", \"password\": \"testPassword\"}"))
      .header("Content-Type", "application/json")
      .check(status is 200)
      .check(jsonPath("$.token").saveAs("token")))

    .exec(http("request_list_colores")
      .get("/colores")
      .header("X-Auth-Token", "${token}"))

  setUp(
    scn.inject(
      rampUsersPerSec(1) to (10) during (5 seconds))).protocols(httpConf)

}
