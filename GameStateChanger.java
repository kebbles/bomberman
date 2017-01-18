import java.awt.*;

public class GameStateChanger {
  
  
  public static int MENU = 1;
  public static int GAME = 2;
  public static int END = 3;
  
  public static int PLAYERONE = 0;
  public static int PLAYERTWO = 1;
  private int winner;
  
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
    else if (curState == END) {
      gameState = new GameEndState(this, winner);
    }
  }
  
  public void setWinner(int player) { winner = player; }
  
  public void update() {
    gameState.update();
  }
  
  public void draw(Graphics2D g) {
    gameState.draw(g);
  }
  
}
