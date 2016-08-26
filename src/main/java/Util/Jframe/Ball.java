package Util.Jframe;

import java.awt.Graphics;

import Util.Planet;

public class Ball {
    private static final int ballWIDTH = 10, ballHEIGHT = 10;
    private Pong game;
    private int x, y; 
    
    private Planet p;
    
    //public void setMod(int mod){ //Experimentller Modus setter, problem - access violation
    //	this.mod = mod;
    //}
    
    public Ball(Pong game){
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }
    
    public void update(){
    	x = (int) p.getPosition().getX();
    	y = (int) p.getPosition().getY();
    }

    public void paint(Graphics g) {
            g.fillOval(x, y, ballWIDTH, ballHEIGHT);
    }
    
    public void setP(Planet p) {
		this.p = p;
	}
}