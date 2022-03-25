package cf;

import java.util.*;
import java.lang.Math;

public class Deck {
  private ArrayList<Card> deck;

  public Deck() {
    this.deck = new ArrayList<Card>();

    for(int suit = 0; suit <= 3; suit++) {
      for(int value = 2; value <= 14; value++) {
        this.deck.add(new Card(value, suit));
      } // end inner for loop
    } // end outer for loop

  } // end constructor method

  public int getLength() {
    return deck.size();
  }

  public void displayDeck() {
    for(Card c : this.deck) {
      System.out.println(c);
    }
  }
  public ArrayList<Card> shuffle() {
    int currentIndex = this.deck.size(); //52
    for(int i = currentIndex-1; i > 0; i--) { 
      int random = (int)Math.floor(Math.random()*currentIndex);
      Card temp = this.deck.get(i);
      this.deck.set(i, this.deck.get(random));
      this.deck.set(random, temp);
    }
    // System.out.println(this.deck.size());
    return deck;
    
  }
  public Card rmcard() {
    // System.out.println(this.deck.size());
    return this.deck.remove(0);
  }

} // end class