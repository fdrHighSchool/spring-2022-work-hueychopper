package cf;
import java.util.ArrayList;
import java.util.regex.*;
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
            System.out.println("top > top2; switching...");
            this.p1.add(top2);
            this.p2.remove(top2);
        } else {
            System.out.println("top2 > top; switching...");
            this.p2.add(top);
            this.p1.remove(top);
        }
    }
    public int getValue(Card currentCard) {
        int val;

        String valdigit = currentCard.toString().replaceAll("\u001B\\[[;\\d]*m", "").substring(0,1);
        Pattern cardvals = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher match = cardvals.matcher(valdigit);
        boolean isNDigit = match.find();

        if(isNDigit) {
            // System.out.println("val:"+valdigit);
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
    public void dis() {
        System.out.println(this.p1);
        System.out.println(this.p1.size());
        System.out.println();
        System.out.println();
        System.out.println(this.p2);
        System.out.println(this.p2.size());
    }
} 