package services

import javax.inject._
import com.google.inject.ImplementedBy
import models.{Reciept, Order, Card}

@ImplementedBy(classOf[BasicBillingService])
trait BillingService {
  def charge(order: Order, card: Card): Reciept
}
