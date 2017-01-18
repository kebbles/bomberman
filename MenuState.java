import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class MenuState extends GameState {
  
  public static int PLAY = 0;
  public static int QUIT = 1;
  
  private int curSelected;
  private GameStateChanger gsc;
  
  private BufferedImage[] bomb;
  private BufferedImage[] font;
  
  
  public MenuState(GameStateChanger gsc) {
    curSelected = PLAY;
    this.gsc = gsc;
    load();
  }
  
  public void update() {
    if (Keys.isPressed(Keys.UP) && curSelected > PLAY) {
      curSelected--;
    }
    else if (Keys.isPressed(Keys.DOWN) && curSelected < QUIT) {
      curSelected++;
    }
    else if (Keys.isPressed(Keys.ENTER)) {
      select(curSelected);
    }
  }
  
  public void draw(Graphics2D g) {
    //g.setColor(Color.black);
    //g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    
    for (int row = 0; row < 12; row++) {
      for (int col = 0; col < 12; col++) {
        g.drawImage(
                    Sprites.BLOCK[Tile.BREAKABLE],
                    col * 50,
                    row * 50,
                    null
                   );
      }
    }
    
    stringDraw("BOMBERMAN", 210, 153, g);
    stringDraw("PLAY", 250, 253, g);
    stringDraw("QUIT", 250, 273, g);
    
    if (curSelected == 0) g.drawImage(bomb[0], 230, 250, null);
    else if (curSelected == 1) g.drawImage(bomb[0], 230, 270, null);
  }
  
  public void select(int selected) {
    if (selected == PLAY) {
      gsc.setState(gsc.GAME);
    }
    else if (selected == QUIT) {
      System.exit(0);
    }
  }
  
  public void load() {
    try {
      BufferedImage img = ImageIO.read(new File("bomb.gif"));
      int width = img.getWidth();
      int height = img.getHeight();
      bomb = new BufferedImage[12];
      for (int i = 0; i < 12; i++) {
        bomb[i] = img.getSubimage(i * width / 12, 0, width / 12, height);
      }
      
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
