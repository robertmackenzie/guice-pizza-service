package services

import javax.inject._
import com.google.inject.ImplementedBy
import models.Card

@ImplementedBy(classOf[BasicCardsService])
trait CardsService {
  var cards: List[Card]

  def all: List[Card]

  def add(card: Card): Unit
}
