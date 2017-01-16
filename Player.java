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
    //System.out.println(moving + " " + down);
  }
  
  public void setPosition(int a, int b) {
    x = a;
    y = b;
    xdest = x;
    ydest = y;
    rowTile = y / tileSize;
    colTile = x / tileSize;
  }
  
  public void plantBomb() {
    
  }
  
  public int getRow() { return rowTile; }
  public int getCol() { return colTile; }
  
  
  public boolean canNextPosition() {
    
    if (moving) return true;
    
    if (left) {
      if (colTile == 0 || map.getType(rowTile, colTile - 1) == Tile.BLOCKED || map.getType(rowTile, colTile - 1) == Tile.BREAKABLE)
        return false;
      else 
        xdest = x - tileSize;
    }
    else if (right) {
      if (colTile == map.getNumCols() || map.getType(rowTile, colTile + 1) == Tile.BLOCKED || map.getType(rowTile, colTile + 1) == Tile.BREAKABLE)
        return false;
      else 
        xdest = x + tileSize;
    }
    else if (up) {
      if (rowTile == 0 || map.getType(rowTile - 1, colTile) == Tile.BLOCKED || map.getType(rowTile - 1, colTile) == Tile.BREAKABLE)
        return false;
      else
        ydest = y - tileSize;
    }
    else if (down) {
      if (rowTile == map.getNumRows() || map.getType(rowTile + 1, colTile) == Tile.BLOCKED || map.getType(rowTile + 1, colTile) == Tile.BREAKABLE)
        return false;
      else 
        ydest = y + tileSize;
    }
    
    return true;
    
  }
  
  public void nextPosition() {
    //System.out.println(left + " " + right + " " + up + " " + down);
    if (left && x > xdest) x -= speed;
    else left = false;
    if (left && x < xdest) x = xdest;
    
    if (right && x < xdest) x += speed;
    else right = false;
    if (right && x > xdest) x = xdest;
    
    if (up && y > ydest) y -= speed;
    else up = false;
    if (up && y < ydest) y = ydest;
    
    if (down && y < ydest) y += speed;
    else down = false;
    if (down && y > ydest) y = ydest;
    
  }
  
  public void update() {
    //System.out.println("moving: " + moving);
    //System.out.println(x + " " + xdest + " " + y + " " + ydest);
    //System.out.println(rowTile + " " + colTile);
    if (moving) nextPosition();
    
    if (x == xdest && y == ydest) {
      //System.out.println("------------------------------------------------------------");
      left = right = up = down = moving = false;
      rowTile = y / tileSize;
      colTile = x / tileSize;
    }
  }
  
  public void draw(Graphics2D g) {
    //g.drawImage(sprite, x, y, null);
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, 50, 50);
  }
  
}
