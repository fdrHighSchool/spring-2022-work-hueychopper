import java.util.*;

public class Connect {
    public static void main(String[] args) {
        boolean win = false;
        System.out.println("input format: (char),(column)");
        String[][] board = new String[6][7];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = "[ ]";
            }
        }
        formatBoard(board);

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("player1: ");
            String p1 = inputHandle(board, sc.nextLine());
            if(p1.equals("[x]")) {
                win = true;
                sc.close();
                break;
            }
            System.out.print("player2: ");
            String p2 = inputHandle(board, sc.nextLine());
            if(p2.equals("[o]")) {
                win = true;
                sc.close(); break;
            }
        }
    }
    public static void formatBoard(String[][] bd) {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        for(int row = 0; row < bd.length; row++) {
            for(int col = 0; col < bd[row].length; col++) {
                System.out.print(bd[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static String inputHandle(String[][] bd, String coords) {
        int com = coords.indexOf(",");
        String uchar = coords.substring(0,com);
        int colNum = Integer.parseInt(coords.substring(com+1));
        
        String winner1 = "";
        String winner2 = "";
        for(int row = bd.length-1; row > -1; row--) {
            if(bd[row][colNum-1] == "[ ]") {
                bd[row][colNum-1] = "["+uchar+"]";
                formatBoard(bd);
                winner1 = checkWinner(bd, colNum, "[x]");
                winner2 = checkWinner(bd, colNum, "[o]");
                if(!winner1.equals("0")) {
                    return winner1;
                } else if(!winner2.equals("0")) {
                    return winner2;
                }
                break;
            }
        }
        return "";
    }
    public static String checkWinner(String[][] bd, int cCol, String uchar) {
        for(int row = 0; row < bd.length; row++) {
            for(int col = 0; col < bd[row].length; col++) {
                String sEl = bd[row][col];
                if(sEl.equals(uchar)) {
                    if(col <= bd[row].length-4 && sEl.equals(bd[row][col+1]) && sEl.equals(bd[row][col+2]) && sEl.equals(bd[row][col+3])) {
                        System.out.println(uchar+" win horizontal");
                        return uchar;
                    }
                    if(row <= bd.length-4 && sEl.equals(bd[row+1][col]) && sEl.equals(bd[row+2][col]) && sEl.equals(bd[row+3][col])) {
                        System.out.println(uchar+" win vertical");
                        return uchar;
                    }
                    for(int i = 3; i < bd.length; i++) {//set row bounds
                        for(int j = 0; j < bd[row].length-3; j++){ //set col bounds
                            if (bd[i][j].equals(uchar) && bd[i-1][j+1].equals(uchar) && bd[i-2][j+2].equals(uchar)
                            && bd[i-3][j+3].equals(uchar) ) {
                                System.out.println(uchar+" diagonal win");
                                return uchar;
                            }
                        }
                    }
                    for(int i = 3; i < bd.length; i++) {
                        for(int j = 3; j < bd[row].length-3; j++) {
                            if(bd[i][j].equals(uchar) && bd[i-1][j-1].equals(uchar) && bd[i-2][j-2].equals(uchar) && bd[i-3][j-3].equals(uchar) ) {
                                System.out.println(uchar+" diagonal win");
                                return uchar;
                            }
                        }
                    }
                }
            }
        }
        return "0";
    }
}
