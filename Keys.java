import java.awt.*;
import java.awt.event.*;

public class Keys {
  
  private static boolean[] keys1 = new boolean[6];
  private static boolean[] keys2 = new boolean[6];
  
  public static int UP = 0;
  public static int DOWN = 1;
  public static int LEFT = 2;
  public static int RIGHT = 3;
  public static int ENTER = 4;
  public static int PLANT = 5;
  
  public static void set(int n, boolean b) {
    if (n == KeyEvent.VK_UP) keys1[UP] = b;
    else if (n == KeyEvent.VK_DOWN) keys1[DOWN] = b;
    else if (n == KeyEvent.VK_LEFT) keys1[LEFT] = b;
    else if (n == KeyEvent.VK_RIGHT) keys1[RIGHT] = b;
    else if (n == KeyEvent.VK_ENTER) keys1[ENTER] = b;
    else if (n == KeyEvent.VK_SEMICOLON) keys1[PLANT] = b;
    
    if (n == KeyEvent.VK_W) keys2[UP] = b;
    else if (n == KeyEvent.VK_S) keys2[DOWN] = b;
    else if (n == KeyEvent.VK_A) keys2[LEFT] = b;
    else if (n == KeyEvent.VK_D) keys2[RIGHT] = b;
    else if (n == KeyEvent.VK_ENTER) keys2[ENTER] = b;
    else if (n == KeyEvent.VK_F) keys2[PLANT] = b;
  }
  
  public static boolean isPressed(int n) {
    return keys1[n];
  }
  
  public static boolean isPressed2(int n) {
    return keys2[n];
  }
  
  
}
