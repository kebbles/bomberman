import java.awt.*;

abstract class GameState {
  
  public GameState() { 
   
  }
  
  abstract void update();
  abstract void draw();
  
}
