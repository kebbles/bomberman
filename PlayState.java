import java.awt.*;

public class PlayState extends GameState {
  
  private GameStateChanger gsc;
  
  public PlayState(GameStateChanger gsc) { 
    this.gsc = gsc;
  }
  
  public void update() {
  }
  
  public void draw(Graphics2D g) {
    g.setColor(Color.red);
    g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
  }
  
}
