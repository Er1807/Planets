package Util;

public class Mathlib {
	private Mathlib() {
	};

	private static final double G = 6.6741;

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
			x += (pos[i].getX() * pecentg);
			y += (pos[i].getY() * pecentg);
			z += (pos[i].getZ() * pecentg);
		}

		return new Vector3d(x, y, z);

	}

	public static double calculateg(Vector3d pos, double m, Vector3d pos2) {

		return g(m, pythagorean_quadruple(pos, pos2));
	}

	public static double calculategtotal(Vector3d[] pos, double[] m, Vector3d pos2) {
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

	public static Vector3d calculatenewdirectionandspeed(Planet[] outher, Planet own) {
		Vector3d[] pos = new Vector3d[outher.length];
		double[] mass = new double[outher.length];
		for (int i = 0; i < outher.length; i++) {
			pos[i] = outher[i].getPosition();
			mass[i] = outher[i].getMass();
		}
		Vector3d poscentral = calculatepoint(pos, mass, own.getPosition());
		double cforce = centripetalforce(own.getMass(), own.getDirectionandspeed(), pythagorean_quadruple(poscentral, own.getPosition()));
		double gtotal = calculategtotal(pos, mass, own.getPosition());
		double total = cforce + gtotal;
		double pcforce = cforce / total;
		double pgtotal = gtotal / total;
		if (pgtotal == pcforce) {
			return own.getDirectionandspeed();
		} else {
			Vector3d line = new Vector3d(poscentral.getX() - own.getPosition().getX(), poscentral.getY() - own.getPosition().getY(), poscentral.getZ() - own.getPosition().getZ());
			return new Vector3d(own.getDirectionandspeed().getX() + line.getX() * pgtotal + line.getX() * -0, own.getDirectionandspeed().getY() + line.getY() * pgtotal + line.getY() * -0,
					own.getDirectionandspeed().getZ() + line.getZ() * pgtotal + line.getZ() * -0);
		}
	}

	public static void updateall(Planet[] planets) {
		int current = 0;
		boolean found = false;
		Planet[] temp = new Planet[planets.length - 1];
		Planet temp2 = null;
		for (int i = 0; i < planets.length; i++) {
			found = false;
			for (int j = 0; j < planets.length; j++) {
				if (j == current) {
					
					found = true;
					temp2 = planets[j];
				} else if (found) {
					
					temp[j - 1] = planets[j];
				} else {
					temp[j] = planets[j];
				}
			}
			temp2.setDirectionandspeed(Mathlib.calculatenewdirectionandspeed(temp, temp2));
			temp2.getPosition().add(temp2.getDirectionandspeed().getX() * 1 / 100, temp2.getDirectionandspeed().getY() * 1 / 100, temp2.getDirectionandspeed().getZ() * 1 / 100);

			current++;
		}
	}

}
