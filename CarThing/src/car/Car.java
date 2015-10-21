package car;

import physics.Vector;

public class Car {
	
	public static final transient long dt = 30;
	
	Vector location;
	double speed, alphaWheel, alphaCar;
	
	public Car(Vector location, double alphaCar) {
		this.location = location;
		this.alphaCar = alphaCar;
	}
	
	public void move(double acc) {
		location = location.add(Vector.fromPolar(speed, alphaCar).multiply(dt));
		alphaCar += alphaWheel;
		speed += acc;
	}
	
	public void move() {
		this.move(0);
	}

}
