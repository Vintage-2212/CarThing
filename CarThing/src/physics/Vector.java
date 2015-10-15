package physics;

public class Vector {
	
	public final double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector add(Vector other) {
		return new Vector(this.x + other.x, this.y + other.y);
	}
	
	public Vector subtract(Vector other) {
		return this.add(other.negate());
	}
	
	public Vector mul(Vector other) {
		return new Vector(this.x * other.x, this.y * other.y);
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
