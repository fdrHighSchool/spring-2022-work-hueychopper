import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

String[][] bd;
int rows = 6;
int cols = 7;
String checkCol = "";
int currentRound = 1;
String currentPiece = "";
String gameState = "setup"; //"play","gameover"
int letKey = 1;

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
  if(gameState.equals("setup")) {
    if(key == 'p') {
      gameState = "play";
    }
  } else if(gameState.equals("play")) {
    if(keyCode != 10) {
      Pattern pattern = Pattern.compile("[1-7]", Pattern.CASE_INSENSITIVE); //regex. dont need to go through multiple if statements
      Matcher match = pattern.matcher(Character.toString(key));
      boolean isMatch = match.find();
      if(isMatch) {
        checkCol = Character.toString(key);
      }
      loop();
    } else {
      currentRound++;
      loop();
      checkCol = "";
    }
  } else if(gameState.equals("gameover")) {
    //println("from keypress: gameover");
    if(keyPressed) {
      keyPressed = false;
    } 
  }
}
void draw() {
  background(0);
  if(gameState.equals("setup")) {
    textSize(30);
    text("Welcome to the game\npress p to begin", 180, height/2);
  } else if(gameState.equals("play")) {
    textSize(20);
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
        text(checkCol, 200, 0);
        inputHandler(bd,currentPiece);
      }
    } else if(currentRound % 2 == 0) {
      currentPiece = "o";
      text("player2 input col: ", 0, 0);
      if(!checkCol.equals("")) {
        text(checkCol, 200, 0);
        inputHandler(bd,currentPiece);
      }
    }
    popMatrix();
    stroke(0);
    formatBoard();
    //println("from play condition: "+gameState);
  }
  if(gameState.equals("gameover")) {
    loop();
    background(0);
    text("winner found", 200, height/2);
  }
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
  String winner = "";
  int column = Integer.parseInt(checkCol);
  
  for(int row = bd.length-1; row > -1; row--) {
    if(bd[row][column-1].equals(" ")) {
      bd[row][column-1] = cp;
      winner = checkwinner(bd);
      noLoop();
      break;
    }
  }
  if(!winner.equals("false")) {
    gameState = "gameover";
  }
}
String checkwinner(String[][] bd) {
  for(int row = 0; row < bd.length; row++) {
    for(int col = 0; col < bd[row].length; col++) {
      String element = bd[row][col];
      if(element.equals(currentPiece)) {
        if(col <= bd[row].length-4 && element.equals(bd[row][col+1]) && element.equals(bd[row][col+2]) && element.equals(bd[row][col+3])) {
          println(currentPiece+" win horizontal");
          return currentPiece;
        }
        if(row <= bd.length-4 && element.equals(bd[row+1][col]) && element.equals(bd[row+2][col]) && element.equals(bd[row+3][col])) {
          println(currentPiece+" win vertical");
          return currentPiece;
        }
        for(int i = 3; i < bd.length; i++) {//set row bounds
          for(int j = 0; j < bd[row].length-3; j++){ //set col bounds
            if(bd[i][j].equals(currentPiece) && bd[i-1][j+1].equals(currentPiece) && bd[i-2][j+2].equals(currentPiece) && bd[i-3][j+3].equals(currentPiece) ) {
              println(currentPiece+" diagonal win");
              return currentPiece;
            }
          }
        }
        for(int i = 3; i < bd.length; i++) {
          for(int j = 3; j < bd[row].length-3; j++) {
            if(bd[i][j].equals(currentPiece) && bd[i-1][j-1].equals(currentPiece) && bd[i-2][j-2].equals(currentPiece) && bd[i-3][j-3].equals(currentPiece) ) {
              println(currentPiece+" diagonal win");
              return currentPiece;
            }
          }
        }
      }
    }
  }
  return "false";
}
