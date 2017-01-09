import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.inputStreamReader;

import javax.imageio.ImageIO;


public class Map {
  
  private int[][] map;
  private int tileSize;
  private int numRows;
  private int numCols;
  
  public Map(int tileSize) { 
   tileSize = this.tileSize;
  }
  
  public void loadMap() {
    try {
      InputStream in = getClass().getResourceAsStream(s);
      BufferedReader br = new BufferedReader( new InputStreamReader(in) );
      
      numCols = Integer.parseInt(br.readLine());
      numRows = Integer.parseInt(br.readLine());
      map = new int[numRows][numCols];
      
      String delim = "\\s+";
      for (int row = 0; row < numRows; row++) {
        String line = br.readLine();
        for (int col = 0; col < numCols; col++) {
          String[] parts = line.split(delim);
          map[row][col] = Integer.parseInt(parts[col]);
        }
      }
    
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
