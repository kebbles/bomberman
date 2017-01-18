import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprites {
  
  public static BufferedImage[] BOMB = loadBomb();
  public static BufferedImage[] EXPLOSION = loadExplosion();
  
  public static BufferedImage[] BLOCK = loadBlock();
  public static BufferedImage[] LIFE = loadLife();
  
  public static BufferedImage[][] PLAYER = loadPlayer();
  
  public static BufferedImage[] loadBomb() {
    BufferedImage[] ret = new BufferedImage[4];
    try {
      ret[0] = ImageIO.read(new File("bomb1.gif"));
      ret[1] = ImageIO.read(new File("bomb2.gif"));
      ret[2] = ImageIO.read(new File("bomb3.gif"));
      ret[3] = ImageIO.read(new File("bomb4.gif"));
     }
    catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }
  
  public static BufferedImage[] loadExplosion() {
    BufferedImage[] ret = new BufferedImage[1];
    try {
      ret[0] = ImageIO.read(new File("boom.gif"));
     }
    catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }
  
  public static BufferedImage[] loadBlock() {
    BufferedImage[] ret = new BufferedImage[3];
    try {
      ret[0] = ImageIO.read(new File("tile.gif"));
      ret[1] = ImageIO.read(new File("wall.gif"));
      ret[2] = ImageIO.read(new File("box.gif"));
     }
    catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }
  
  public static BufferedImage[][] loadPlayer() {
    BufferedImage[][] ret = new BufferedImage[4][3];
    try {
      ret[0][0] = ImageIO.read(new File("down1.gif"));
      ret[0][1] = ImageIO.read(new File("down2.gif"));
      ret[0][2] = ImageIO.read(new File("down3.gif"));
      
      ret[1][0] = ImageIO.read(new File("left1.gif"));
      ret[1][1] = ImageIO.read(new File("left2.gif"));
      ret[1][2] = ImageIO.read(new File("left3.gif"));
      
      ret[2][0] = ImageIO.read(new File("up1.gif"));
      ret[2][1] = ImageIO.read(new File("up2.gif"));
      ret[2][2] = ImageIO.read(new File("up3.gif"));
      
      ret[3][0] = ImageIO.read(new File("right1.gif"));
      ret[3][1] = ImageIO.read(new File("right2.gif"));
      ret[3][2] = ImageIO.read(new File("right3.gif"));
     }
    catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }
  
  public static BufferedImage[] loadLife() {
    BufferedImage[] ret = new BufferedImage[1];
    try {
      ret[0] = ImageIO.read(new File("life.gif"));
     }
    catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }
  
}
