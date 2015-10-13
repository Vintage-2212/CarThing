package signs;

public class MinSpeedSign extends Sign {

	private int speed;

	public MinSpeedSign(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}
	
	public String toString() {
		return super.toString() + "(" + speed + ")";
	}
}
