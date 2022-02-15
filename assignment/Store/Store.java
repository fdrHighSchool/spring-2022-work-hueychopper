package Store;
import java.util.Arrays;

public class Store {
    private int id;
    private String name;
    private boolean closeContact;
    private int[] grades = new int[5];

    public Store(int uid, String uname, int[] sGrades, boolean... cc) {//
        this.id = uid;
        this.name = uname;
        this.closeContact = cc.length > 0 ? cc[0] : false; 
        for(int i = 0; i < sGrades.length; i++) {
            grades[i] = sGrades[i];
        }
        filterCC(true);
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
    public double getAverage() {
        int total = 0;
        for(int grade : grades) {
            total += grade;
        }
        return total / grades.length;
    }

    public void setCloseContact(boolean value) {
        this.closeContact = value;
    }
    public boolean isFailing() {
        if(this.getAverage() < 65.0) {
            return true;
        }
        return false;
    }
    public String toString() {
        return this.name+": "+this.id;
    }
}
