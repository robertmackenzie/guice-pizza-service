package services

import javax.inject._
import models.{Reciept, Order, Card}

@Singleton
class BasicBillingService() extends BillingService {
  def charge(order: Order, card: Card): Reciept = {
    Reciept(id = "1", decription = order.description)
  }
}
