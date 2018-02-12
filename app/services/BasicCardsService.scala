package services

import javax.inject._
import models.Card

@Singleton
class BasicCardsService() extends CardsService {
  var cards: List[Card] = List.empty[Card]

  def all: List[Card] = cards

  def add(card: Card): Unit = {
    cards = card :: cards
  }
}
