import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bomb {
  
 private int x;
 private int y;
 private Map map;
 private int tileSize;
 
 private Player playerOne;
 private Player playerTwo;
 
 private static boolean explode;
 
 private BufferedImage[] sprites;
 private int currentFrame;
 
 public static long time;
 private boolean again;
 
 public Bomb(int x, int y, Map mp, Player p1, Player p2) {
   
  this.x = x;
  this.y = y;
  
  map = mp;
  tileSize = map.getTileSize();
  
  playerOne = p1;
  playerTwo = p2;
  
  explode = false;
  
  sprites = Sprites.BOMB;
  time = 0;
  again = false;
  
 }
 
 public int getCol() { return x; }
 public int getRow() { return y; }
 
 public static boolean canExplode() { 
   return explode;
 }
 
 public void update() {
   if (time < 250) currentFrame = 0;
   else if (time < 500) currentFrame = 1;
   else if (time < 750) currentFrame = 2;
   else if (time <= 1000) {
     currentFrame = 3;
     explode = true;
   }
   
   time++;
 }
 
 public void draw(Graphics2D g) {
   g.drawImage(
               sprites[currentFrame],
               x * tileSize + tileSize / 4,
               y * tileSize + tileSize / 4,
               null
              );
   
   if (explode && !again) {
     //int x = b.getCol();
     //int y = b.getRow();
     int playerX = playerOne.getCol();
     int playerY = playerOne.getRow();
     int player2X = playerTwo.getCol();
     int player2Y = playerTwo.getRow();
     
     //System.out.println("||||||||||||||||||||||||||||||||");
     
     for (int col = x; col >= (x - 3) && col >= 0; col--) {
       if (map.getType(y, col) == Tile.BLOCKED) break;
       g.drawImage(
                   Sprites.EXPLOSION[0],
                   col * tileSize + tileSize / 4,
                   y * tileSize + tileSize / 4,
                   null
                  );
       if (playerX == col && playerY == y) playerOne.hurt();
       if (player2X == col && player2Y == y) { playerTwo.hurt(); System.out.println("1"); }  
       map.setTile(y, col, Tile.NORMAL);
     }
     for (int col = x; col <= (x + 3) && col <= map.getNumCols(); col++) {
       if (map.getType(y, col) == Tile.BLOCKED) break;
         g.drawImage(
                   Sprites.EXPLOSION[0],
                   col * tileSize + tileSize / 4,
                   y * tileSize + tileSize / 4,
                   null
                  );
       if (playerX == col && playerY == y) playerOne.hurt();
       if (player2X == col && player2Y == y) { playerTwo.hurt(); System.out.println("2"); } 
       map.setTile(y, col, Tile.NORMAL);
     }
     for (int row = y; row >= (y - 3) && row >= 0; row--) {
       if (map.getType(row, x) == Tile.BLOCKED) break;
         g.drawImage(
                   Sprites.EXPLOSION[0],
                   x * tileSize + tileSize / 4,
                   row * tileSize + tileSize / 4,
                   null
                  );
       if (playerX == x && playerY == row) playerOne.hurt();
       if (player2X == x && player2Y == row)  { playerTwo.hurt(); System.out.println("3"); } 
       map.setTile(row, x, Tile.NORMAL);
     }
     for (int row = y; row <= (y + 3) && row <= map.getNumRows(); row++) {
       if (map.getType(row, x) == Tile.BLOCKED) break;
         g.drawImage(
                   Sprites.EXPLOSION[0],
                   x * tileSize + tileSize / 4,
                   row * tileSize + tileSize / 4,
                   null
                  );
       if (playerX == x && playerY == row) playerOne.hurt();
       if (player2X == x && player2Y == row) { playerTwo.hurt(); System.out.println("4"); }  
       map.setTile(row, x, Tile.NORMAL);
       
     }
     
     again = true;
     //System.out.println("//////////////////////////////");
   }
   
 }
 
 
 
}