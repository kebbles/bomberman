import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class GameEndState extends GameState {
  
  private GameStateChanger gsc;
  private BufferedImage[] font;
  
  private int whoWon;
  
  public GameEndState(GameStateChanger gsc, int won) { 
    this.gsc = gsc;
    whoWon = won;
    load();
  }
  
  public void draw(Graphics2D g) {
    g.setColor(Color.black);
    g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    
    stringDraw("GAME", 210, 153, g);
    stringDraw("OVER", 290, 153, g);
    
    if (whoWon == gsc.PLAYERONE) {
      stringDraw("PLAYER", 150, 253, g);
      stringDraw("ONE", 280, 253, g);
      stringDraw("WINS", 360, 253, g);
    }
    else {
      stringDraw("PLAYER", 150, 253, g);
      stringDraw("TWO", 280, 253, g);
      stringDraw("WINS", 360, 253, g);
    }
  }
  
  public void update() {
    if (Keys.isPressed(Keys.UP))
      gsc.setState(gsc.MENU);
  }
  
   public void load() {
    try {
      BufferedImage img = ImageIO.read(new File("bomb.gif"));
      int width = img.getWidth();
      int height = img.getHeight();
      /*
      bomb = new BufferedImage[12];
      for (int i = 0; i < 12; i++) {
        bomb[i] = img.getSubimage(i * width / 12, 0, width / 12, height);
      }
      */
      
      img = ImageIO.read(new File("font.gif"));
      width = img.getWidth();
      height = img.getHeight();
      font = new BufferedImage[27];
      int cnt = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 12; j++) {
          font[cnt] = img.getSubimage(j * width / 12, i * height / 3, width / 12, height / 3);
          cnt++;
          if (cnt == 26) break;
        }
      }
    } 
    catch(Exception e) {
      e.printStackTrace();
    }
  }
   
   public void stringDraw(String s, int x, int y, Graphics2D g) {
    int width = font[0].getWidth();
    for (int i = 0; i < s.length(); i++) {
      g.drawImage(font[s.charAt(i) - 'A'], x + i * width, y, null);
    }
  }
  
}
