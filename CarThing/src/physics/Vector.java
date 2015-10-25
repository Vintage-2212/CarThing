package physics;

public class Vector {

	public final double x, y;
	public static final Vector ZERO = new Vector(0, 0);

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector add(Vector other) {
		return new Vector(this.x + other.x, this.y + other.y);
	}

	public static Vector fromPolar(double radius, double phase) {
		return new Vector(radius * Math.cos(phase), radius * Math.sin(phase));
	}

	public Vector subtract(Vector other) {
		return this.add(other.negate());
	}

	public Vector multiply(Vector other) {
		return new Vector(this.x * other.x, this.y * other.y);
	}
	
	public Vector multiply(double c) {
		return new Vector(x*c, y*c);
	}

	public Vector negateX() {
		return new Vector(-this.x, this.y);
	}

	public Vector negateY() {
		return new Vector(this.x, -this.y);
	}

	public Vector negate() {
		return this.negateX().negateY();
	}

}
