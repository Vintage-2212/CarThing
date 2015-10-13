package signs;

import java.util.HashSet;
import java.util.Set;

public class MaxSpeedSign extends Sign {

	private int speed;

	public MaxSpeedSign(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}
	
	public String toString() {
		return super.toString() + "(" + speed + ")";
	}
}
