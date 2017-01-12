import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Player {
  
  private int x;
  private int y;
  private int xdest;
  private int ydest;
  private int rowTile;
  private int colTile;
  
  private boolean moving;
  private boolean left;
  private boolean right;
  private boolean up;
  private boolean down;
  
  private int speed;
  
  private BufferedImage sprite;
  
  private Map map;
  private int tileSize;
  
  
  public Player(Map mp) { 
    map = mp;
    tileSize = map.getTileSize();
    speed = 5;
  }
  
  public void setLeft() {
    if (moving) return;
    left = true;
    moving = canNextPosition();
  }
  
  public void setRight() {
    if (moving) return;
    right = true;
    moving = canNextPosition();
  }
  
  public void setUp() {
    if (moving) return;
    up = true;
    moving = canNextPosition();
  }
  
  public void setDown() {
    if (moving) return;
    down = true;
    moving = canNextPosition();
    System.out.println(moving + " " + down);
  }
  
  public void setPosition(int a, int b) {
    x = a;
    y = b;
  }
  
  public boolean canNextPosition() {
    
    int row = 1;
    int col = 1;
    
    if (moving) return true;
    
    if (left) {
      if (col == 0 || map.getType(row, col - 1) == Tile.BLOCKED)
        return false;
      else 
        xdest = x - tileSize;
    }
    else if (right) {
      if (col == map.getNumCols() || map.getType(row, col + 1) == Tile.BLOCKED)
        return false;
      else 
        xdest = x + tileSize;
    }
    else if (up) {
      if (row == 0 || map.getType(row - 1, col) == Tile.BLOCKED)
        return false;
      else
        ydest = y - tileSize;
    }
    else if (down) {
      if (row == map.getNumRows() || map.getType(row + 1, col) == Tile.BLOCKED)
        return false;
      else 
        ydest = y + tileSize;
    }
    
    return true;
    
  }
  
  public void nextPosition() {
    //System.out.println(y + " " + ydest + " " + speed);
    if (left && x > xdest) x -= speed;
    else if (left && x < xdest) x = xdest;
    
    if (right && x < xdest) x += speed;
    else if (right && x > xdest) x = xdest;
    
    if (up && y < ydest) y -= speed;
    else if (up && y > ydest) y = ydest;
    
    if (down && y < ydest) y += speed;
    else if (down && y > ydest) y = ydest;
    
  }
  
  public void update() {
    System.out.println("moving: " + moving);
    if (moving) nextPosition();
    
    if (x == xdest && y == ydest) {
      System.out.println("------------------------------------------------------------");
      left = right = up = down = moving = false;
      rowTile = x / tileSize;
      colTile = y / tileSize;
    }
  }
  
  public void draw(Graphics2D g) {
    //g.drawImage(sprite, x, y, null);
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, 50, 50);
  }
  
}
