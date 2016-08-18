package controllers

import com.giogar.football.data.v0.Client
import com.giogar.football.data.v0.models.json._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext.Implicits.global

class Fixtures extends Controller {

  private val fixturesClient = new Client().fixtures

  def getFixturesByCompetitionId(competitionId: Long) = Action.async {
    fixturesClient.getFixturesByCompetitionId(competitionId).map(fixturesClient => Ok(Json.toJson(fixturesClient)))
  }

}
