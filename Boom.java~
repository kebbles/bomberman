import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Boom extends Rectangle implements ActionListener {
	private ImageIcon boom;
	private Timer myTimer;
	private int counter;
	public Boom(int x, int y){
		this.x = x;
		this.y = y;
		this.width = 28;
		this.height = 30;
		counter=0;
		boom = new ImageIcon("boom.gif");
		myTimer= new Timer(1200,this);
		myTimer.start();
	}
	public ImageIcon getBoom(){
		return boom;
	}
	public Timer getT(){
		return myTimer;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (Panel.pause){
			myTimer.stop();
		}
		else myTimer.start();
		if (arg0.getSource() == myTimer)
			counter++;
	}
	public int getC(){
		return counter;
	}
}