public class AOF {
    public static void main(String[] args) {
        int[] g1 = {90,80,95,90,100}, g2 = {95,100,100,90,90}, g3 = {85,85,95,100,90}, g4 = {90,100,75,85,90}, g5 = {80,80,65,55,90};
        int[] id = {1234567, 9876543,1357911,2468101,1928374};
        String[] name = {"Jimmy SMith", "Maria Hernandez", "Jamal Jenkins","Ramiz Ahmad", "Michael Green"};
        boolean[] cc = {true, false, false, true, true};

        for(int i = 0; i < cc.length; i++) {
            if(cc[i] == true) {
                System.out.println(name[i]);
            }
        }
    }
}