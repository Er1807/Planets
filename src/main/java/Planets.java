import java.util.Random;

import Util.Mathlib;
import Util.Planet;
import Util.Vector3d;
import Util.Jframe.Pong;

public class Planets {

	public static void main(String[] args) {

		// test
		Planet[] planets = new Planet[400];
		if(args.length==1){
			planets = new Planet[Integer.parseInt(args[0])];
		}
		
		Random r = new Random();
		
		for (int i = 0; i < planets.length; i++) {
			planets[i]=new Planet(new Vector3d(r.nextInt(700), r.nextInt(700), 0), new Vector3d(r.nextDouble()*5, r.nextDouble()*5, 0), r.nextDouble()*1000+5);
		}
		Pong p = new Pong(planets);
		
		p.getPanel().update();
		
		while (true) {
			
			
			Mathlib.updateall(planets);
			p.getPanel().update();
			
			
		}

	}

}
