import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bomb extends Rectangle implements ActionListener {
 private ImageIcon[] bomb;
 private Timer myTimer;
 private int mode, whichP;
 
 private int x;
 private int y;
 
 public static long time; 
 
 public Bomb(int x, int y) {
  this.x = x;
  this.y = y;
  whichP = player;
  this.width = 28;
  this.height = 30;
  bomb = new ImageIcon[]{new ImageIcon("bomb1.gif"),new ImageIcon("bomb2.gif"),new ImageIcon("bomb3.gif"),new ImageIcon("bomb4.gif")};
  mode = 0;
  myTimer = new Timer(1000,this);
  myTimer.start();
  time = 0;
 }

 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == myTimer&&mode < 3&&!Panel.pause)
   mode++;
 }
 
 public void explode() {
   for (int col = x; col >= (x - 3) && col >= 0; col--) {
     
   }
 }
 
 public int getRow() { return y; }
 public int getCol() { return x; }
 
 public ImageIcon bombFuse() {
  return bomb[mode%4];
 }
 public Timer getTimer(){
  return myTimer;
 }
 public int getP() {
  return whichP;
 }
 public int getM(){
  return mode;
 }
 
}