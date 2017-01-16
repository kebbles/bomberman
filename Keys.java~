import java.awt.*;
import java.awt.event.*;

public class Keys {
  
  private static boolean[] keys = new boolean[5];
  
  public static int UP = 0;
  public static int DOWN = 1;
  public static int LEFT = 2;
  public static int RIGHT = 3;
  public static int ENTER = 4;
  
  public static void set(int n, boolean b) {
    if (n == KeyEvent.VK_UP) keys[UP] = b;
    else if (n == KeyEvent.VK_DOWN) keys[DOWN] = b;
    else if (n == KeyEvent.VK_LEFT) keys[LEFT] = b;
    else if (n == KeyEvent.VK_RIGHT) keys[RIGHT] = b;
    else if (n == KeyEvent.VK_ENTER) keys[ENTER] = b;
  }
  
  public static boolean isPressed(int n) {
    return keys[n];
  }
  
  
  
}
