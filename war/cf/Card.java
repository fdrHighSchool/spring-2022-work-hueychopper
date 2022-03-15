package cf;
public class Card {
    private int value;
    private int suit;
    private String color;
  
    public Card(int v, int s) {
      this.value = v;
      this.suit = s;
  
      if(s == 1 || s == 3) {
        color = "black";
      } // end if statement
      else {
        color = "red";
      } // end else statement
  
    } // end constructor method
  
    public String toString() {
      String card = "";
      if(color.equals("red")) {
        // red text
        card += "\033[0;31m";
      }
      else {
        // black text
        card += "\033[0;30m";
      }
      // white background
      card += "\033[47m";
  
      if(value < 11) {
        card += value;
      }
      else if(value == 11) {
        card += "jack";
      }
      else if(value == 12) {
        card += "queen";
      }
      else if(value == 13) {
        card += "king";
      }
      else {
        card += "ace";
      }
  
      if(suit == 0) {
        card += " of diamonds";
      }
      else if(suit == 1) {
        card += " of clubs";
      }
      else if(suit == 2) {
        card += " of hearts";
      }
      else {
        card += " of spades";
      }
  
      return card;
    } // end toString method
  
} // end class