import java.awt.*;

public class GameStateChanger {
  
  
  public static int MENU = 1;
  public static int GAME = 2;
  
  private GameState gameState;
  private int curState;
  
  public GameStateChanger() { 
    setState(MENU);
  }
  
  public void setState(int state) {
    curState = state;
    if (curState == MENU) {
      gameState = new MenuState(this);
    }
    else if (curState == GAME) {
      gameState = new PlayState(this);
    }
  }
  
  public void update() {
    if (curState == MENU) {
      gameState.update();
    }
    else if (curState == GAME) {
      gameState.update();
    }
  }
  
  public void draw(Graphics2D g) {
    gameState.draw(g);
  }
  
}
