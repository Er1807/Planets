package Util;

public class Vector3d {

	private double x, y, z;

	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public double lenght(){
		return Math.sqrt((x*x)+(y*y)+(z*z));
		
	}

	@Override
	public String toString() {
		return ("x=" + x + " y=" + y + "z=" + z);
	}

	public void add(double i, double j, double k) {
		x+=i;
		y+=j;
		z+=k;
	}

}
