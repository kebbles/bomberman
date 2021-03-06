import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;


public class Map {
  
  private Tile[][] map;
  private int tileSize;
  private int numRows;
  private int numCols;
  
  private static int NORMAL = 0;
  private static int BLOCKED = 1;
  
  public Map(int tileSize) { 
   this.tileSize = tileSize;
   numRows = numCols = 12;
  }
  
  public int getTileSize() { return tileSize; }
  
  public int getType(int row, int col) { return map[row][col].getType(); }
  public void setTile(int row, int col, int type) { map[row][col].setType(type); }
  
  public int getNumRows() { return numRows; }
  public int getNumCols() { return numCols; }
  
  
  public void loadMap(String s) {
    try {
      InputStream in = getClass().getResourceAsStream(s);
      BufferedReader br = new BufferedReader( new InputStreamReader(in) );
      
      numCols = Integer.parseInt(br.readLine());
      numRows = Integer.parseInt(br.readLine());
      map = new Tile[numRows][numCols];
      
      String delim = "\\s+";
      for (int row = 0; row < numRows; row++) {
        String line = br.readLine();
        for (int col = 0; col < numCols; col++) {
          String[] parts = line.split(delim);
          map[row][col] = new Tile(Integer.parseInt(parts[col]));
        }
      }
    
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void draw(Graphics2D g) {
    for (int row = 0; row < numRows; row++) {
      
      for (int col = 0; col < numCols; col++) {
        BufferedImage[] block = new BufferedImage[1];
        if (map[row][col].getType() == Tile.NORMAL) {
             block[0] = Sprites.BLOCK[Tile.NORMAL];
        }
        else if (map[row][col].getType() == Tile.BLOCKED) {
          block[0] = Sprites.BLOCK[Tile.BLOCKED];
        }
        else if (map[row][col].getType() == Tile.BREAKABLE) {
          block[0] = Sprites.BLOCK[Tile.BREAKABLE];
        }
        
         //g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
         g.drawImage(
               block[0],
               col * tileSize,
               row * tileSize,
               null
              );
      }
    }
  }
  
}
