import java.util.*;
public class ArrayResizer {
    public static void main(String[] args) {
        int[][] arr = {{2,1,0},{1,3,2},{0,0,0},{4,5,6}};
        System.out.println(isNonZeroRow(arr,0));
        System.out.println(isNonZeroRow(arr,1));
        System.out.println(isNonZeroRow(arr,2));
        System.out.println(isNonZeroRow(arr,3));
        System.out.println(Arrays.deepToString(resize(arr)));
    }
    public static boolean isNonZeroRow(int[][] arr, int r) {
        for(int c = 0; c < arr[r].length; c++) {
            if(arr[r][c]==0) {
                return false;
            }
        }
        return true;
    }
    public static int numNonZeroRows(int[][] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(isNonZeroRow(arr, i)) {
                count++;
            }
        }
        return count;
    }
    public static int[][] resize(int[][] arr) {
        int[][] smaller = new int[numNonZeroRows(arr)][arr[0].length]; //2 is row number because the original problem had a method which return 2 as the answer. the method would've gone in the place of 2.
        int ix = 0;
        for(int i = 0; i < arr.length; i++) {
            if(isNonZeroRow(arr,i)) {
                smaller[ix] = arr[i];
                ix += 1;
            }
        }
        return smaller;
    }
}
