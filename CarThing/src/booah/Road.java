package booah;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Alon
 *
 *
 *         Represents a single road piece
 */
public class Road {
	
	public int code;
	public static final Direction[] all = Direction.values();
	
	/**
	 * An array of the physical roads that lead to the road
	 */
	private Direction[] directions;

	public Road(Direction[] directions) {
		this.directions = directions;
		for(int i = 0; i < all.length; i++) {
			if (contains(all[i])) {
				code += (1 << i);
			}
		}
	}

	public Direction[] getDirections() {
		return directions;
	}
	
	public boolean contains(Direction dir) {
		for (Direction d : directions) {
			if (d == dir) {
				return true;
			}
		}
		return false;
	}

	public static Road decode(String roadType) {
		List<Direction> toAdd = new ArrayList<>();
		int code = Integer.parseInt(roadType, 16);
		for (int i = 0; i < all.length; i++) {
			if ((code & (1 << i)) != 0) {
				toAdd.add(all[i]);
			}
		}
		return new Road((Direction[]) toAdd.toArray(new Direction[toAdd.size()]));
	}
	
	
	public String encode() {
		return Integer.toHexString(code);
	}
}
