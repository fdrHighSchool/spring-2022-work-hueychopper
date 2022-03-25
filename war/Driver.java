import java.util.*;
import cf.Deck;
import cf.Card;
import cf.Pile;

public class Driver {
  public static void main(String[] args) {
    Deck deck = new Deck();
    ArrayList<Card> p1 = new ArrayList<Card>();
    ArrayList<Card> p2 = new ArrayList<Card>();

    // deck.displayDeck();

    deck.shuffle();
    for(int i = 0; i < 26; i++) { //deck.getLength() always changes, hard coded value needed
      p1.add(deck.rmcard());
      p2.add(deck.rmcard());
    }

    Pile one = new Pile(p1, p2);
    one.round();
    one.display();

  }
}