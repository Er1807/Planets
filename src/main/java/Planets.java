import java.util.Scanner;

import Util.Mathlib;
import Util.Planet;
import Util.Vector3d;
import Util.Jframe.Pong;

public class Planets {

	public static void main(String[] args) {

		// test

		Pong p = new Pong();

		Planet p1 = new Planet(new Vector3d(350, 350, 0), new Vector3d(100, 50, 0), 500);
		Planet p2 = new Planet(new Vector3d(-450, 350, 0), new Vector3d(-55, -100, 0), 1000);

		Planet p3 = new Planet(new Vector3d(500, 500, 0), new Vector3d(2, 5, 0), 1000);

		p.getPanel().getBall().setP(p1);
		p.getPanel().getBall2().setP(p2);
		p.getPanel().getBall3().setP(p3);

		p.getPanel().update();
		Scanner sc = new Scanner(System.in);
		Vector3d[] pos = new Vector3d[] { p1.getPosition(), };
		double[] mass = new double[] { p1.getMass() };
		while (true) {
			//System.out.println(p3.getPosition());
			p3.setDirectionandspeed(Mathlib.calculatenewdirectionandspeed(pos, mass, p3.getDirectionandspeed(), p3.getPosition(), p3.getMass()));
			//System.out.println(p3.getPosition());
			p3.getPosition().add(p3.getDirectionandspeed().getX()*1/20,p3.getDirectionandspeed().getY()*1/20,p3.getDirectionandspeed().getZ()*1/20);			
			p.getPanel().update();
			p.getPanel().repaint();
			//System.out.println("pos= "+p3.getPosition());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
