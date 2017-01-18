import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class HUD {
  
  private Player playerOne;
  private Player playerTwo;
  
  private BufferedImage lifeIcon;
  
  public HUD(Player p1, Player p2) { 
   
    playerOne = p1;
    playerTwo = p2;
    
    lifeIcon = Sprites.LIFE[0];
    
  }
  
  public void draw(Graphics2D g) {
    int x = 50;
    int y = 25;
    int lives = playerOne.getLives();
    for (int i = 0; i < lives; i++) {
      g.drawImage(
                  lifeIcon, 
                  x * i + 25,
                  y, 
                  null
                 );
    }
    
    lives = playerTwo.getLives();
    for (int i = 0; i < lives; i++) {
      g.drawImage(
                  lifeIcon, 
                  x * i + 450,
                  y, 
                  null
                 );
    }
  }
 
  
}
