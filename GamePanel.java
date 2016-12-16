import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class GamePanel extends JPanel implements Runnable {
  
  public static int WIDTH = 600;
  public static int HEIGHT = 600;
  
  private Thread thread;
  private boolean running;
  
  private BufferedImage canvas;
  private Graphics2D g;
  
  private int FPS = 30;
  private double avgFPS;
  
  public static GameStateChanger gsc;
  
  public GamePanel() { 
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    requestFocus();
  }
  
  public void addNotify() {
    super.addNotify();
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }
  
  public void run() {
    running = true;
    
    canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    g = (Graphics2D) canvas.getGraphics();
    
    gsc = new GameStateChanger(0);
    
    long startTime;
    long timeMillis;
    long waitTime;
    long totalTime = 0;
    
    int frameCount = 0;
    int maxFrameCount = 30;
    
    long targetTime = 1000 / FPS;
    
    while (running) {
      
      startTime = System.nanoTime();
      
      gameUpdate();
      gameRender();
      gameDraw();
      
      timeMillis = (System.nanoTime() - startTime) / 1000000;
      waitTime = targetTime - timeMillis;
      
      try {
        Thread.sleep(waitTime);
      }
      catch(Exception ex) {
      }
      
      totalTime += System.nanoTime() - startTime;
      frameCount++;
      if (frameCount == maxFrameCount) {
        avgFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
        frameCount = 0;
        totalTime = 0;
      }
      
    }
  }
  
  public void gameUpdate() {
    
  }
  
  public void gameRender() {
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setColor(Color.RED);
    g.drawString("FPS: " + avgFPS, 100, 100);
  }
  
  public void gameDraw() {
    Graphics g2 = this.getGraphics();
    g2.drawImage(canvas, 0, 0, null);
    g2.dispose();
  }
  
  
}
