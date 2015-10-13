package booah;

/**
 * 
 * @author Alon
 *
 *
 *         Represents a single road piece
 */
public abstract class Road {
	/**
	 * An array of the physical roads that lead to the road
	 */
	private Direction[] directions;

	public Road(Direction[] directions) {
		this.directions = directions;
	}

	public Direction[] getDirections() {
		return directions;
	}

	public static Road decode(String roadType) {
		return null;
	}
}
