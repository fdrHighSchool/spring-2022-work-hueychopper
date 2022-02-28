import metrocard.MetroCard;

class Tester {
    public static void main(String[] args) {
        //examples
        MetroCard mc = new MetroCard();
        if(mc.getType() == "Special Access") {
            mc.pay();
            // mc.cardTimer(); //this works in with real time. if this.timeLeft = 1, the program will
            //wait one minute to reallow metro card swipe;
        } else {
            mc.pay();
        }
        MetroCard mc1 = new MetroCard(10.0);
        mc1.addToBalance(13.5);
        mc1.getBalance();
    }
}