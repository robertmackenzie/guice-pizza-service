package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._

class OrdersControllerSpec
extends PlaySpec
with GuiceOneAppPerTest
with Injecting {
  "OrdersController POST" should {
    val orderRequest = FakeRequest(POST, "/orders").withJsonBody(
      JsObject(Map(
        "card" -> JsObject(Map(
          "number" -> JsString("01234")
        )),
        "order" -> JsObject(Map(
          "price" -> JsString("40"),
          "description" -> JsString("an order for pizza")
        ))
      ))
    )

    val expectedReciept  = JsObject(Seq(
      "id" -> JsNumber(1),
      "description" -> JsString("an order for pizza")
    ))

    "return a 201 CREATED status" in {
      val reciept = route(app, orderRequest).get

      status(reciept) mustBe CREATED
    }

    "return a recipet" in {
      val reciept = route(app, orderRequest).get

      contentAsJson(reciept) mustEqual expectedReciept
    }
  }
}
