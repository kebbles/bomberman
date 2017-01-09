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
    
    map = new Map(16);
    map.loadMap("test.txt");
    
    player = new Player(map);
    player.setPosition(20, 20);
    
  }
  
  public void update() {
    
  }
  
  public void draw(Graphics2D g) {
    map.draw(g);
  }
  
}
