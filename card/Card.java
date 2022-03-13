

public class Card {
    public class PlayingCard {
        private String type; //diamonds, spades, hearts, clovers
        private String color; //red, black
        private int value; // 2,3,4,5,6,7,8,9,10,jack,queen,king,ace

        public PlayingCard() {
            System.out.println("obj");
        }
    }
    public static void main(String[] args) {
        Card outC = new Card();
        Card.PlayingCard one = outC.new PlayingCard(); //nested class. :(
    }
}