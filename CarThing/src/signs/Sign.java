package signs;

public abstract class Sign {

	public String toString() {
		return getClass().getSimpleName() + "~";
	}
	
	public static Sign decode(String sign) {
		switch(sign.substring(0, sign.indexOf('~'))) {
		case "MaxSpeedSign":
			return new MaxSpeedSign(Integer.parseInt(sign.substring(sign.indexOf("(") + 1).replace(")", "")));
		case "MinSpeedSign":
			return new MinSpeedSign(Integer.parseInt(sign.substring(sign.indexOf("(") + 1).replace(")", "")));
		case "StopSign":
			return StopSign.getInstance();
		case "TrafficLight":
			return new TrafficLight();
		default:
			throw new IllegalSignCodeException(sign);
		}
	}
	
	public static class IllegalSignCodeException extends RuntimeException {
		public IllegalSignCodeException(String sign) {
			super(sign);
		}
	};

}
