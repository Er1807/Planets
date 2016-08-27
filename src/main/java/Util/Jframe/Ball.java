package Util.Jframe;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

import Util.Planet;

public class Ball {
    private static final int ballWIDTH = 10, ballHEIGHT = 10;
    private int x, y; //mod;
    Planet p ;
    
    //public void setMod(int mod){ //Experimentller Modus setter, problem - access violation
    //	this.mod = mod;
    //}
    
    public Ball(){
    }
    
    public void update(){
    	this.x = (int) p.getPosition().getX();
    	this.y = (int) p.getPosition().getY();
    }

    public void paint(Graphics g) {
            g.fillOval(x, y, ballWIDTH, ballHEIGHT);
    }

	public void setP(Planet planet) {
		p=planet;
		
	}
}