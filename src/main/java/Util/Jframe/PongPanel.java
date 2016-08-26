package Util.Jframe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PongPanel extends JPanel {
	private Pong game;
	private Ball ball3;
	private Ball ball2;
	private Ball ball;

	public PongPanel(Pong game) {
		setBackground(Color.WHITE);
		ball = new Ball(game);
		ball2 = new Ball(game);
		ball3 = new Ball(game);
		
	}

	public void update(){
		ball.update();
		ball2.update();
		ball3.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.paint(g);
		ball2.paint(g);
		ball3.paint(g);

	}

	public Ball getBall() {
		return ball;
	}

	public Ball getBall2() {
		return ball2;
	}

	public Ball getBall3() {
		return ball3;
	}
}