import java.util.Arrays;

class Cell {
  private boolean liveStatus;
  
  Cell(boolean status) {
    this.liveStatus = status;
  }
  boolean getState() {
    return this.liveStatus;
  }
  void setState(boolean state) {
    this.liveStatus = state;
  }
  void writeString() {
    println("state: "+this.liveStatus);
    if(this.liveStatus) {
      println("is alive");
    }
  }
}
