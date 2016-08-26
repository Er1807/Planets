package Util.Jframe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Util.Planet;

@SuppressWarnings("serial")
public class PongPanel extends JPanel {
	private Pong game;
	private Ball[] balls;

	public PongPanel(Planet[] planets) {
		setBackground(Color.WHITE);
		balls = new Ball[planets.length];
		for (int i = 0; i < planets.length; i++) {
			balls[i]=new Ball();
			balls[i].setP(planets[i]);
		}
	}

	public void update(){
		for (int i = 0; i < balls.length; i++) {
			balls[i].update();
		}
		this.repaint();
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < balls.length; i++) {
			balls[i].paint(g);
		}
	}

	
}