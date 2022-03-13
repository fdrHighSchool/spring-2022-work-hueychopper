import java.util.Arrays;
import java.util.ArrayList;

Grid grid;
void setup() {
  size(900, 600);
  grid = new Grid(40,60);
  frameRate(20);
  noLoop();
}
void draw() {
  background(0);
  grid.displayGrid();
  
  Cell[][] rcell = new Cell[grid.rows][grid.cols];
  
    for(int i = 1; i < grid.rows-1; i++) {
      for(int j = 1; j < grid.cols-1; j++) {
        int nn = grid.getNumNeighbors(i,j);
        rcell[i][j] = new Cell(false);
        if(grid.cells[i][j].getState() && nn < 2) {
            rcell[i][j].setState(false);
        } else if(grid.cells[i][j].getState() && nn > 3) {
            rcell[i][j].setState(false);
        } else if(grid.cells[i][j].getState() == false && nn == 3) {
            rcell[i][j].setState(true);
        } else {
            rcell[i][j] = grid.cells[i][j];
        }
      }
    }
    grid.nextGenDisplay(rcell);
}
