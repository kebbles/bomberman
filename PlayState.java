import java.awt.*;
import java.util.ArrayList;

public class PlayState extends GameState {
  
  private Player player;
  private Player player2;
  
  private Map map;
  private HUD hud;
  
  private GameStateChanger gsc;
  
  public static ArrayList<Bomb> bombs;
  
  public PlayState(GameStateChanger gsc) { 
    this.gsc = gsc;
    init();
  }
  
  public void init() {
    
    bombs = new ArrayList<Bomb>();
    
    map = new Map(50);
    map.loadMap("test.txt");
    
    player = new Player(map);
    player.setPosition(50, 50);
    
    player2 = new Player(map);
    player2.setPosition(450, 450);
    
    hud = new HUD(player, player2);
  }
  
  
  
  public void update() {
    
    if (player.getLives() <= 0 || player2.getLives() <= 0) 
      endGame();
    
    takeInput();
    
    checkBombs();
    for (Bomb b : bombs) { 
      b.update();
    }
    
    player.update();
    player2.update();
  }
  
  public void draw(Graphics2D g) {
    map.draw(g);
    
    for (Bomb b : bombs) {
      b.draw(g);
    }
    
    player.draw(g);
    player2.draw(g);
    
    hud.draw(g);
    
  }
  
  public void takeInput() {
    if (Keys.isPressed(Keys.LEFT)) { player.setLeft(); } 
    else if (Keys.isPressed(Keys.RIGHT)) { player.setRight(); }
    else if (Keys.isPressed(Keys.UP)) { player.setUp(); }
    else if (Keys.isPressed(Keys.DOWN)) { player.setDown(); }
    else if (Keys.isPressed(Keys.PLANT)) {
      //System.out.println("BOMB");
      bombs.add(new Bomb(player.getCol(), player.getRow(), map, player, player2));
    }
    
    if (Keys.isPressed2(Keys.LEFT)) { player2.setLeft(); } 
    else if (Keys.isPressed2(Keys.RIGHT)) { player2.setRight(); }
    else if (Keys.isPressed2(Keys.UP)) { player2.setUp(); }
    else if (Keys.isPressed2(Keys.DOWN)) { player2.setDown(); }
    else if (Keys.isPressed2(Keys.PLANT)) {
      //System.out.println("BOMB");
      bombs.add(new Bomb(player2.getCol(), player2.getRow(), map, player, player2));
    }
  }
  
  public void checkBombs() {
    for (int i = 0; i < bombs.size(); i++) {
      Bomb b = bombs.get(i);
      if (b.canExplode()) {
        bombs.remove(i);
        i--;
      }
      else b.update();
    }
  }
  
  public void endGame() {
    if (player.getLives() <= 0) gsc.setWinner(gsc.PLAYERTWO);
    else gsc.setWinner(gsc.PLAYERONE);
    gsc.setState(gsc.END);
  }
  
  
}
