package controllers

import com.giogar.football.data.v0.Client
import com.giogar.football.data.v0.models.json._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext.Implicits.global

class Competitions extends Controller {

  private val competitionsClient = new Client().competitions

  def get() = Action.async {
    competitionsClient.get().map(competitions => Ok(Json.toJson(competitions)))
  }

  def getTeamsByCompetitionId(competition_id: Long) = Action.async {
    competitionsClient.getTeamsByCompetitionId(competition_id).map(teams => Ok(Json.toJson(teams)))
  }

  def getFixturesByCompetitionId(competitionId: Long) = Action.async {
    competitionsClient.getFixturesByCompetitionId(competitionId).map(fixturesClient => Ok(Json.toJson(fixturesClient)))
  }

  def getLeagueTableByCompetitionId(competitionId: Long) = Action.async {
    competitionsClient.getLeagueTableByCompetitionId(competitionId).map(leagueTable => Ok(Json.toJson(leagueTable)))
  }

}
