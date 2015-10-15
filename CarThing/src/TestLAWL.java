import java.util.Arrays;

import booah.Map;
import booah.Road;
import booah.Tile;

public class TestLAWL {
	
	
	public static void main(String[] args) {
//			Tile t = new Tile(Road.decode("F"));
//			t.addEntranceSign(Direction.SOUTH, StopSign.getInstance());
//			t.addEntranceSign(Direction.EAST, new TrafficLight());
//			t.addEntranceSign(Direction.SOUTH, new MaxSpeedSign(80));
	////
//			t.addExitSign(Direction.NORTH, new MinSpeedSign(20));
//			t.addExitSign(Direction.WEST, new TrafficLight());
//			t.addExitSign(Direction.WEST, new MinSpeedSign(10));
//			System.out.println(t.encode() + "\n");
//			System.out.println(Tile.decode(t.encode()).encode());
			Tile[][] t = new Tile[4][4];
			int i = 0, j = 0;
			for (char c : "0123456789abcdef".toCharArray()) {
				if(i == 4) {
					i = 0;
					j += 1;
				}
				t[i][j] = new Tile(Road.decode(c + ""));
				i++;
			}
			Map m = new Map(t);
			System.out.println(m.encode().equals(Map.decode(m.encode()).encode()));

	}

}
