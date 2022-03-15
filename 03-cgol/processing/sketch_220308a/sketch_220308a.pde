import java.util.Arrays;
import java.util.ArrayList;

Grid grid;
void setup() {
  size(900, 600);
  grid = new Grid(40,60);
  //frameRate(20);
  noLoop();
}
void draw() {
  background(0);
  grid.displayGrid();
  grid.update();
  delay(2000);
  grid.update();
}
