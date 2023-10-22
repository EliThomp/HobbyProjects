package edu.ics211.h07;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameOfWarTest2 {
  private GameOfWar game;
  
  @BeforeEach
  void setUp() throws Exception {
    game = new GameOfWar();
  }

  @Test
  void testPlayARound() {
    Card[] cards = new Card[6];
    Deck d = new Deck(cards);
    Stack<Card> p1 = game.playerOnesCards();
    Stack<Card> p2 = game.playerTwosCards();
    cards[5] = new Card(Suit.CLUBS, Rank.FIVE);
    cards[4] = new Card(Suit.DIAMONDS, Rank.FIVE);
    cards[3] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[2] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[1] = new Card(Suit.HEARTS, Rank.ACE);
    cards[0] = new Card(Suit.SPADES, Rank.KING);
    d = new Deck(cards);
    game.initializeGame(d);
    assertTrue(game.playARound());
    p1 = game.playerOnesCards();
    p2 = game.playerTwosCards();
    assertTrue(p1.empty());
    assertFalse(p2.empty());
  }

}
