package Store;
import java.util.Arrays;

public class Store {
    private int id;
    private String name;
    private boolean closeContact;
    private int[] grades = new int[5];

    public Store(int uid, String uname, boolean cc, int[] sGrades) {//
        this.id = uid;
        this.name = uname;
        this.closeContact = cc;
        for(int i = 0; i < sGrades.length; i++) {
            grades[i] = sGrades[i];
        }
        filterCC(true);
        // System.out.println("filter set to true.");
    }
    public void getId() {
        System.out.println(this.id);
    }
    public void getArray() {
        System.out.println(Arrays.toString(grades));
    }
    public void getContactStatus() {
        System.out.println(this.closeContact);
    }
    public void getName() {
        System.out.println("name: "+this.name);
    }
    public void filterCC(boolean displayName) {
        if(this.closeContact == true) {
            if(displayName == true) {
                getName();
            }
        }
    }
}
