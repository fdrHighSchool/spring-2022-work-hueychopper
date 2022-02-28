package metrocard;
import java.util.Date;
import java.util.Calendar;

public class MetroCard {
    private double balance;
    private int timeLeft = 0;

    public MetroCard(double... bal) {
        this.balance = bal.length > 0 ? bal[0] : -1.0;
    }
    public String getType() {
        if(this.balance == -1.0) {
            return "Special Access";
        }
        return "Payed Card";
    }
    public void pay() { //also can be called swipe
        if(getType() == "Payed Card") {
            if(this.balance >= 2.75) {
                this.balance -= 2.75;
            }
        } else {
            System.out.println("You can go on.");
            this.timeLeft = 1; //set to 1 for testing, in reality its 20min until next swipe
        }
    }
    public void getBalance() {
        System.out.println("Remaining amount: "+this.balance);
    }
    public void addToBalance(double amnt) {
        this.balance += amnt;
    }
    public void cardTimer() {
        Calendar now = Calendar.getInstance();
        final int ctime = now.get(Calendar.MINUTE), csec = now.get(Calendar.SECOND);
<<<<<<< HEAD
        final int ftime = ctime + 1; //change
=======
        final int ftime = ctime + this.timeLeft;
>>>>>>> 114f1d1 (vf)

        while(this.timeLeft > 0) {
            Calendar update = Calendar.getInstance();
            if((ftime == update.get(Calendar.MINUTE)) && (csec == update.get(Calendar.SECOND))) {
                this.timeLeft = 0;
                System.out.println("one more swipe available");
            }
        }
    }
}
