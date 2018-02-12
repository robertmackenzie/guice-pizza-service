package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import services.BillingService
import models.{Order, Card, Reciept}

@Singleton
class OrdersController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def create() = Action(parse.json) { request =>
    //val reciept = BillingService.charge(Order(), Card())

    //Created(reciept)
    Created("")
  }
}
