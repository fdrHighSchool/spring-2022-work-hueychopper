package cf;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Collections;
import cf.Card;
import cf.Deck;

public class Pile {
    Deck init = new Deck();
    private ArrayList<Card> p1;
    private ArrayList<Card> p2;
    
    public Pile(ArrayList<Card> p1, ArrayList<Card> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    public void round() {
        Card top = this.p1.get(0);
        Card top2 = this.p2.get(0);

        if(getValue(top) > getValue(top2)) {
            System.out.println("top: "+top+" > top2: "+top2);
            this.p1.add(top2);
            this.p2.remove(top2);
        } else if(getValue(top2) > getValue(top)) {
            System.out.println("top2: "+top2+" > top: "+top);
            this.p2.add(top);
            this.p1.remove(top);
        } else if(getValue(top) == getValue(top2)) {
            Card warTop = this.p1.get(1);
            Card warTop2 = this.p2.get(1);
            System.out.println("war declared::: card1: "+top+", card2: "+top2);
            if(getValue(warTop) > getValue(warTop2)) {
                Collections.addAll(this.p1, this.p2.get(0), this.p2.get(1), this.p2.get(2), this.p2.get(3), this.p2.get(4));
                for(int i = 0; i <= 4; i++) {this.p2.remove(i);}
            }   
            else {
                Collections.addAll(this.p2, this.p1.get(0), this.p1.get(1), this.p1.get(2), this.p1.get(3), this.p1.get(4));
                for(int i = 0; i <= 4; i++) {this.p1.remove(i);}
            }
        }
    }
    public int getValue(Card currentCard) {
        int val;
        String valdigit = currentCard.toString().replaceAll("\u001B\\[[;\\d]*m", "").substring(0,1);
        Pattern cardvals = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher match = cardvals.matcher(valdigit);
        boolean isNDigit = match.find();

        if(isNDigit) {
            val = Integer.parseInt(valdigit);
        } else {
            System.out.println(currentCard.toString());
            String identifier = currentCard.toString().substring(0,currentCard.toString().indexOf(" "));
            if(identifier.equals("jack")) {
                val = 11;
            } else if(identifier.equals("queen")) {
                val = 12;
            } else if(identifier.equals("king")) {
                val = 13;
            } else {
                val = 14;
            }
        }
        return val;
    }
    public void display() {
        System.out.println(this.p1);
        System.out.println(this.p1.size());
        System.out.println();
        System.out.println();
        System.out.println(this.p2);
        System.out.println(this.p2.size());
    }
} 