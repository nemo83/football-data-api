package controllers

import com.giogar.football.data.v0.Client
import com.giogar.football.data.v0.models.json._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext.Implicits.global

class Teams extends Controller {

  private val teamsClient = new Client().teams

  def getByTeamId(team_id: Long) = Action.async {
    teamsClient.getByTeamId(team_id).map(team => Ok(Json.toJson(team)))
  }

  def getFixturesByTeamId(team_id: Long) = Action.async {
    teamsClient.getFixturesByTeamId(team_id).map(fixtures => Ok(Json.toJson(fixtures)))
  }

  def getPlayersByTeamId(team_id: Long) = Action.async {
    teamsClient.getPlayersByTeamId(team_id).map(players => Ok(Json.toJson(players)))
  }

}
