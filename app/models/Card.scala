package models

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.json.Writes._
import play.api.libs.functional.syntax._

case class Card(number: String)

object Card {
  val numberPath = (JsPath \ "number")

  object Implicits {
    implicit val cardReads: Reads[Card] = numberPath
      .read[String]
      .map(Card.apply)

    implicit val cardWrites: Writes[Card] =  numberPath
      .write[String]
      .contramap(unlift(Card.unapply))
  }
}
