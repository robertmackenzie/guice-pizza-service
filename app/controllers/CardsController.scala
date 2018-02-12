package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.ws._
import play.api.libs.json._
import services.{BillingService, CardsService}
import models.{Order, Card, Reciept}

@Singleton
class CardsController @Inject()(cs: CardsService, cc: ControllerComponents)
extends AbstractController(cc) {
  import models.Card.Implicits._

  def create() = Action(parse.json) { request =>
    val card = request.body.validate[Card]

    card match {
      case JsSuccess(card, _) => {
        cs.add(card)
        Created(JsString(""))
      }
      case e: JsError => BadRequest(JsError.toJson(e))
    }
  }

  def index() = Action { request =>
    Ok(Json.toJson(cs.all))
  }
}
