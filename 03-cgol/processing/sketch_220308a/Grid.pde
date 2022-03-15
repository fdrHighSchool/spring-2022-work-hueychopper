import java.util.*;
class Grid {
  Cell[][] cells;
  int generation;
  int rows;
  int cols;
  
  Grid(int r, int c) {
    this.rows = r;
    this.cols = c;
    cells = new Cell[r][c];
    this.generation = 1;

    for(int i = 0; i < this.cells.length; i++) {
      for(int j = 0; j < this.cells[i].length; j++) {
        if((i == 2 && (j == 1||j==3)) || (i==3 && (j==2||j==3)) || (i==1&&j==3)) {
          this.cells[i][j] = new Cell(true);
          //getNumNeighbors(i,j);
        }
        else {
          this.cells[i][j] = new Cell(false);
        }
      }
    }
  }
  int getNumNeighbors(int cr, int cl) {
    int neighbors = 0;
    for(int i = -1; i <= 1; i++) {
      for(int j = -1; j <= 1; j++) {
        if(this.cells[cr+i][cl+j] != null && this.cells[cr+i][cl+j].getState()) {
          neighbors++;
        }
      }
    }
    if(this.cells[cr][cl].getState()) {
      neighbors--;
    }
    //println("element: "+this.cells[cr][cl].getState()+", neighbors: "+neighbors, "grid-placement: "+cr+","+cl);
    return neighbors;
  }
  
  void displayGrid() {
    for(int i = 0; i < this.cells.length; i++) {
      for(int j = 0; j < this.cells[i].length; j++) {
        if(cells[i][j].getState()) {
          stroke(100,100,0);
          fill(255,0,0);
        } else {
          stroke(0);
          fill(200);
        }
        rect(15*j,15*i,15,15);
      }
    }
  }
  void update() {
    Cell[][] rcell = new Cell[grid.rows][grid.cols];
    println("generation: "+Integer.toString(generation));
    for(int i = 1; i < grid.rows-1; i++) {
      for(int j = 1; j < grid.cols-1; j++) {
        int nn = grid.getNumNeighbors(i,j);
        
        if(grid.cells[i][j].getState() && nn < 2) {
          //rcell[i][j].setState(false);
          rcell[i][j] = new Cell(false);
        } else if(grid.cells[i][j].getState() && nn > 3) {
          //rcell[i][j].setState(false);
          rcell[i][j] = new Cell(false);
        } else if(grid.cells[i][j].getState() == false && nn == 3) {
          //rcell[i][j].setState(true);
          rcell[i][j] = new Cell(true);
        } else {
          rcell[i][j] = grid.cells[i][j];
        }
      }
    }
    generation++;
    for(int i = 0; i < rcell.length; i++) {
      for(int j = 0; j < rcell[i].length; j++) {
        if(rcell[i][j] != null) {
          if(rcell[i][j].getState()) {
            stroke(100,100,0);
            fill(255,0,0);
          } else {
            stroke(0);
            fill(200);
          }
          rect(15*j,15*i,15,15);
        }
      }
    }
  }
}
