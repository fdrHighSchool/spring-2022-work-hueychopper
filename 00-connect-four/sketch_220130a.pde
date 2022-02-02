import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Rects[][] bd;
String[][] bd;
int rows = 6;
int cols = 7;
String checkCol = "";
int currentRound = 1;
String currentPiece = "";

void setup() {
  size(600,500);
  bd = new String[rows][cols];
  for(int row = 0; row < bd.length; row++) {
    for(int col = 0; col < bd[row].length; col++) {
      bd[row][col] = " ";
    }
  }
  noLoop(); //no loop will cause inputting to break
}

void keyPressed() {
  if(keyCode != 10) {
    Pattern pattern = Pattern.compile("[1-7]", Pattern.CASE_INSENSITIVE); //regex. dont need to go through multiple if statements
    Matcher match = pattern.matcher(Character.toString(key));
    boolean isMatch = match.find();
    if(isMatch) {
      checkCol = Character.toString(key);
      loop();
    }
  } else {
    currentRound++;
    //checkCol = "";
  }
}
void draw() {
  background(0);
   for(int i = 0; i < bd.length; i++) {
    for(int j = 0; j < bd[i].length; j++) {
      stroke(0);
      fill(200);
      rect(50+j*50,50+i*50,50,50);
    }
  }

  fill(255);
  stroke(255);
  pushMatrix();
  translate(50,40);
  if(currentRound % 2 != 0) {
    currentPiece = "x";
    text("player1 input col: ", 0, 0);
    if(!checkCol.equals("")) {
      text(checkCol, 110, 0);
      inputHandler(bd,currentPiece);
    }
  } else if(currentRound % 2 == 0) {
    currentPiece = "o";
    text("player2 input col: ", 0, 0);
    if(!checkCol.equals("")) {
      text(checkCol, 110, 0);
      inputHandler(bd,currentPiece);
    }
  }
  popMatrix();
  stroke(0,0,255);
  formatBoard();
  
}

void formatBoard() {
  pushMatrix();
  for(int i = 0; i < bd.length; i++) {
    for(int j = 0; j < bd[i].length; j++) {
      if(bd[i][j].equals("x")) {
        fill(255,0,0);
        circle(75+j*50,75+i*50,40);
      } else if(bd[i][j].equals("o")) {
        fill(200,200,0);
        circle(75+j*50,75+i*50,40);
      }
    }
  }
  popMatrix();
}

void inputHandler(String[][] bd, String cp) {
  String player1 = "";
  String player2 = "";
  int column = Integer.parseInt(checkCol);
  
  for(int row = bd.length-1; row > -1; row--) {
    if(bd[row][column-1].equals(" ")) {
      bd[row][column-1] = cp;
      noLoop();
      break;
    }
    //formatBoard();
  }
}
