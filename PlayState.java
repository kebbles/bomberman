import java.awt.*;
import java.util.ArrayList;

public class PlayState extends GameState {
  
  private Player player;
  
  private Map map;
  
  private GameStateChanger gsc;
  
  public static ArrayList<Bomb> bombs;
  
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
    
    checkBombs();
    
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
    else if (Keys.isPressed(Keys.PLANT)) {
      System.out.println("BOMB");
      bombs.add(new Bomb(player.getCol(), player.getRow()));
    }
  }
  
  public void checkBombs() {
    for (int i = 0; i < bombs.size(); i++) {
      if (bombs[i].time >= 20) {
        explode(bombs[i]);
        bombs.remove(i);
        i--;
      }
      else bombs[i].time++;
    }
  }
  
  public void explode(Bomb b) {
   int x = b.getCol();
   int y = b.getRow();
   for (int col = x; col >= (x - 3) && col >= 0; col--) {
     if (map.getType(y, col) == Tile.BLOCKED) break;
     map.setTile(y, col, Tile.NORMAL);
   }
   for (int col = x; col <= (x + 3) && col <= map.getNumCols(); col++) {
     if (map.getType(y, col) == Tile.BLOCKED) break;
     map.setTile(y, col, Tile.NORMAL);
   }
   for (int row = y; row >= (y - 3) && row >= 0; row--) {
     if (map.getType(row, x) == Tile.BLOCKED) break;
     map.setTile(row, x, Tile.NORMAL);
   }
   for (int row = y; row <= (y + 3) && row <= map.getNumRows(); row++) {
     if (map.getType(row, x) == Tile.BLOCKED) break;
     map.setTile(row, x, Tile.NORMAL);
   }

 }
  
}
