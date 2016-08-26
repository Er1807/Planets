package Util;

public class Mathlib {
	private Mathlib() {
	};

	private static final double G = 0.66741;

	public static double g(double m, double r) {

		return (G * m) / (r * r);

	}

	public static double pythagorean_quadruple(double a, double b, double c) {

		return Math.sqrt((a * a) + (b * b) + (c * c));
	}

	public static double pythagorean_quadruple(Vector3d v1, Vector3d v2) {

		return pythagorean_quadruple(Math.abs(v1.getX() - v2.getX()), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
	}

	public static Vector3d calculatepoint(Vector3d[] pos, double[] m, Vector3d pos2) {
		double x = 0;
		double y = 0;
		double z = 0;

		double gtotal = 0;
		double gvalues[] = new double[pos.length];

		for (int i = 0; i < pos.length; i++) {
			double g = calculateg(pos[i], m[i], pos2);
			gtotal += g;
			gvalues[i] = g;
		}

		for (int i = 0; i < gvalues.length; i++) {
			double pecentg = gvalues[i] / gtotal;
			System.out.println(pecentg);
			x += (pos[i].getX() * pecentg);
			y += (pos[i].getY() * pecentg);
			z += (pos[i].getZ() * pecentg);
		}

		return new Vector3d(x, y, z);

	}
	
	public static double calculateg(Vector3d pos, double m, Vector3d pos2) {

		return g(m, pythagorean_quadruple(pos, pos2));
	}
	
	public static double calculategtotal(Vector3d[] pos, double[] m, Vector3d pos2){
		double gtotal = 0;
		for (int i = 0; i < pos.length; i++) {
			double g = calculateg(pos[i], m[i], pos2);
			gtotal += g;
		}
		return gtotal;
	}

	public static double centripetalforce(double mass, Vector3d speed, double r) {

		return mass * ((speed.lenght() * speed.lenght()) / r);

	}
	
	public static Vector3d calculatenewdirectionandspeed(double cforce,double gtotal, Vector3d poscentral, Vector3d owndir, Vector3d ownpos){
		
		double total = cforce + gtotal;
		double pcforce = cforce/total;
		double pgtotal = gtotal/total;
		
		if(pgtotal==pcforce){
			return owndir;
		}else {
			Vector3d line = new Vector3d(poscentral.getX()-ownpos.getX(), poscentral.getY()-ownpos.getY(),poscentral.getZ()-ownpos.getZ());
			return new Vector3d(owndir.getX()+line.getX()*pgtotal+line.getX()*-pcforce, owndir.getY()+line.getY()*pgtotal+line.getY()*-pcforce, owndir.getZ()+line.getZ()*pgtotal+line.getZ()*-pcforce);
		}
	}
	
	

}
