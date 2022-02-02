import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Rects[][] bd;
String[][] bd = new String[6][7];
int rows = 6;
int cols = 7;

void setup() {
  size(600,500);
  for(int i = 0;)
  //noLoop(); //no loop will cause inputting to break
}
String checkCol = "";
int currentRound = 1;
void keyPressed() {
  println(keyCode);
  if(keyCode != 10) {
    Pattern pattern = Pattern.compile("[1-9]", Pattern.CASE_INSENSITIVE);
    Matcher match = pattern.matcher(Character.toString(key));
    boolean isMatch = match.find();
    if(isMatch) {
      checkCol = Character.toString(key);
    }
  } else {
    currentRound++;
    checkCol = "";
  }
}
void draw() {
  background(0);

  fill(255);
  stroke(255);
  pushMatrix();
  translate(50,40);
  if(currentRound % 2 != 0) {
    text("player1 input col: ", 0, 0);
    if(!checkCol.equals("")) {
      text(checkCol, 110, 0);
    }
  } else if(currentRound % 2 == 0) {
    text("player2 input col: ", 50, 40);
    if(!checkCol.equals("")) {
      text(checkCol, 160, 40);
    }
  }
  popMatrix();
  pushMatrix();
  translate(120,120);
  for(int i = 0; i < bd.length; i++) {
    for(int j = 0; j < bd[i].length; j++) {
      stroke(0);
      fill(200);
      rect(j*50,i*50,50,50);
    }
  }
  popMatrix();
}

//todo: make droppable piece
