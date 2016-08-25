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
			double r = pythagorean_quadruple(pos[i], pos2);
			double g = g(m[i], r);
			gtotal += g;
			gvalues[i] = g;
		}

		for (int i = 0; i < gvalues.length; i++) {
			double pecentg = gvalues[i]/gtotal;
			x+=(pos[i].getX()*pecentg);
			y+=(pos[i].getY()*pecentg);
			z+=(pos[i].getZ()*pecentg);
		}

		return new Vector3d(x, y, z);

	}

}
