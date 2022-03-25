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

        // getValue(top);
        // getValue(top2);
        if(getValue(top) > getValue(top2)) {
            System.out.println("top: "+top+" > top2: "+top2+" ("+getValue(top)+", "+getValue(top2)+")");
            this.p1.add(top2);
            this.p2.remove(top2);
        } else if(getValue(top2) > getValue(top)) {
            System.out.println("top2: "+top2+" > top: "+top+" ("+getValue(top2)+", "+getValue(top)+")");
            this.p2.add(top);
            this.p1.remove(top);
        } else if(getValue(top) == getValue(top2)) {
            Card warTop = this.p1.get(1);
            Card warTop2 = this.p2.get(1);
            System.out.println("war declared::: card1: "+top+", card2: "+top2);
            if(getValue(warTop) > getValue(warTop2)) {
                System.out.println("top1: "+warTop+" > "+warTop2);
                Collections.addAll(this.p1, this.p2.get(0), this.p2.get(1), this.p2.get(2), this.p2.get(3), this.p2.get(4));
                for(int i = 0; i <= 4; i++) {this.p2.remove(i);}
            }   
            else {
                System.out.println("top2: "+warTop2+" > "+warTop);
                Collections.addAll(this.p2, this.p1.get(0), this.p1.get(1), this.p1.get(2), this.p1.get(3), this.p1.get(4));
                for(int i = 0; i <= 4; i++) {this.p1.remove(i);}
            }
        }
    }
    public int getValue(Card currentCard) {
        int val;

        String valdigit = currentCard.toString().replaceAll("\u001B\\[[;\\d]*m", "");
        String allcase = valdigit.substring(0, valdigit.indexOf(" "));
        Pattern cardvals = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher match = cardvals.matcher(allcase);
        boolean isNDigit = match.find();

        if(isNDigit) {
            // System.out.println("digit: "+valdigit.substring(0, valdigit.indexOf(" ")));
            val = Integer.parseInt(allcase);
        } else {
            if(allcase.equals("jack")) {
                val = 11;
            } else if(allcase.equals("queen")) {
                val = 12;
            } else if(allcase.equals("king")) {
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