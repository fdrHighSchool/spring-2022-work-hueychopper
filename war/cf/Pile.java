package cf;
import java.util.ArrayList;
import java.util.List;
import cf.Deck;

public class Pile {
    Deck init = new Deck();
    List<Card> player1;
    List<Card> player2;

    public Pile() {
        ArrayList<Card> shuffled = init.shuffle();
        player1 = shuffled.subList(0, 26);
        player2 = shuffled.subList(26, 52);
    }
}