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
        if(i == 2 && (j == 2 || j == 3 || j == 4)) {
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
  void nextGenDisplay(Cell[][] newcells) {
    generation++;
    for(int i = 0; i < newcells.length; i++) {
      for(int j = 0; j < newcells[i].length; j++) {
        if(newcells[i][j] != null) {
          if(newcells[i][j].getState()) {
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
