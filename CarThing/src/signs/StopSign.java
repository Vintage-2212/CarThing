package signs;

public class StopSign extends Sign {
	private final static StopSign instance = new StopSign();

	private StopSign() {

	}

	public static StopSign getInstance() {
		return instance;
	}
	
}
