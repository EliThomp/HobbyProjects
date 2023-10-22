package edu.ics211.h07;

public class GameOfWar implements IGameOfWar {
 private Stack<Card> p1Cards = new Stack<Card>();
 private Stack<Card> p2Cards = new Stack<Card>();
 private Stack<Card> roundPile = new Stack<Card>();
 
 private Stack<Card> testP1Cards = new Stack<Card>();
 private Stack<Card> testP2Cards = new Stack<Card>();
  
  /*
   * 
   */
  public GameOfWar() {
  }
  
  @Override
  public void initializeGame(Deck d) {
    while(d.size() != 0) {
      p1Cards.push(d.dealACard());
      p2Cards.push(d.dealACard());
    }

  }


  @Override
  public boolean playARound() {
    
    while(p1Cards.peek().getRank() == p2Cards.peek().getRank()) {     
      
      roundPile.push(p1Cards.pop());
      roundPile.push(p2Cards.pop());
      roundPile.push(p1Cards.pop());
      roundPile.push(p2Cards.pop());
      
    }
    
    //x< -#, x= 0, x> +#
    if(p1Cards.peek().getRank().compareTo(p2Cards.peek().getRank()) > 0) {
      
      //P1 Cards > P2 Cards
      roundPile.push(p2Cards.pop());
      p1Cards = combineStacks(p1Cards, roundPile);
      
      
    } else if(p1Cards.peek().getRank().compareTo(p2Cards.peek().getRank()) < 0) {
      
      //P2 Cards > P1 Cards
      roundPile.push(p1Cards.pop());
      p2Cards = combineStacks(p2Cards, roundPile);
   
    }
    
    if (p1Cards.empty() == true || p2Cards.empty() == true) {
      
      return true;
      
    } else {
      
      return false;
      
    }
   
  }

  @Override
  public Stack<Card> playerOnesCards() {
    // TODO Auto-generated method stub
    return p1Cards;
  }


  @Override
  public Stack<Card> playerTwosCards() {
    // TODO Auto-generated method stub
    return p2Cards;
  }


  @Override
  public Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom) {
    //put all top cards into a stack
    Stack<Card> reverseStack = new Stack<Card>();
    Stack<Card> returnStack = new Stack<Card>();
    //put all bottom cards into a stack
    while(top.empty() == false) {
      reverseStack.push(top.pop());
    }
    while(bottom.empty() == false) {
      reverseStack.push(bottom.pop());
    }
    while(reverseStack.empty() == false) {
      returnStack.push(reverseStack.pop());
    }
    // reverse the deck and pop them into a new deck
    
    return returnStack;
  }

}
