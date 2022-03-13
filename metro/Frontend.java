import metrocard.MetroCard;
import java.lang.Thread;

class Frontend {
    public static void main(String[] args) {
        //examples
        MetroCard mc = new MetroCard("123");
        if(mc.getType() == "Special Access") { //this can also be placed in the constructor
            mc.pay();
            // MCthread t1 = new MCthread();
            mc.cardTimer(); //this works in with real time. if this.timeLeft = 1, the program will wait one minute to reallow metro card swipe;
            // t1.start();
        } else {
            mc.pay();
        }
        
        MetroCard mc1 = new MetroCard("234",10.0);
        System.out.println("-----------------mc1 obj-----------------");
        mc1.addToBalance(13.5);
        mc1.pay();
        mc1.getBalance();


        System.out.println("number of objects is: "+MetroCard.numobj);
        int numOfThreads = MetroCard.numobj;

    }
}
// class MCthread extends Thread {
//     MCthread() {
//         for(int i = 0; i < 10; i++) {
//             // System.out.println("hellow wolrd");
//         }
//     }
// }