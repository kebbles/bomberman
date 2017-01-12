import java.awt.*;

public class PlayState extends GameState {
  
  private Player player;
  
  private Map map;
  
  private GameStateChanger gsc;
  
  public PlayState(GameStateChanger gsc) { 
    this.gsc = gsc;
    init();
  }
  
  public void init() {
    
    map = new Map(50);
    map.loadMap("test.txt");
    
    player = new Player(map);
    player.setPosition(50, 50);
    
  }
  
  public void update() {
    takeInput();
    
    player.update();
  }
  
  public void draw(Graphics2D g) {
    map.draw(g);
    
    player.draw(g);
  }
  
  public void takeInput() {
    if (Keys.isPressed(Keys.LEFT)) player.setLeft();
    else if (Keys.isPressed(Keys.RIGHT)) player.setRight();
    else if (Keys.isPressed(Keys.UP)) player.setUp();
    else if (Keys.isPressed(Keys.DOWN)) player.setDown();
  }
  
}
