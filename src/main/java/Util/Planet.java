package Util;

public class Planet {

	private Vector3d position;
	private Vector3d directionandspeed;
	private double mass;

	public Planet(Vector3d position, Vector3d directionandspeed, double mass) {
		this.position = position;
		this.directionandspeed = directionandspeed;
		this.mass = mass;
	}

	public Vector3d getPosition() {
		return position;
	}

	public void setPosition(Vector3d position) {
		this.position = position;
	}

	public Vector3d getDirectionandspeed() {
		return directionandspeed;
	}

	public void setDirectionandspeed(Vector3d directionandspeed) {
		this.directionandspeed = directionandspeed;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
	
	

}
