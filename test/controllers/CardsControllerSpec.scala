package controllers

import java.util.UUID
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import services.BasicCardsService
import models.Card

class CardsControllerSpec
extends PlaySpec
with StubControllerComponentsFactory
with MockitoSugar
{
  "CardsController#index" when {
    import models.Card.Implicits._

    "there are cards" should {
      val mockCardsService = mock[BasicCardsService]
      val cards = List.fill(5)(UUID.randomUUID).map { uuid =>
        Card(uuid.toString)
      }
      when(mockCardsService.all).thenReturn(cards)

      val cardsController  = new CardsController(mockCardsService, stubControllerComponents())
      val getCardsRequest = FakeRequest(GET, "/cards")
      val getCardsResponse = cardsController
        .index
        .apply(getCardsRequest)

      "return a 200 OK status" in {
        status(getCardsResponse).mustBe(OK)
      }

      "return a list of cards" in {
        contentAsJson(getCardsResponse).mustEqual(Json.toJson(cards))
      }
    }
  }
}
