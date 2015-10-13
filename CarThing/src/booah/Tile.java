package booah;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import signs.MaxSpeedSign;
import signs.MinSpeedSign;
import signs.Sign;
import signs.StopSign;
import signs.TrafficLight;

public class Tile {

	private Road road;
	private Hashtable<Direction, Set<Sign>> entranceSigns;
	private Hashtable<Direction, Set<Sign>> exitSigns;

	public Tile() {
		entranceSigns = new Hashtable<>();
		exitSigns = new Hashtable<>();
	}

	public void addEntranceSign(Direction d, Sign s) {
		if (!entranceSigns.containsKey(d)) {
			Set<Sign> set = new HashSet<Sign>();
			set.add(s);
			entranceSigns.put(d, set);
		} else {
			entranceSigns.get(d).add(s);
		}
	}

	public void addExitSign(Direction d, Sign s) {
		if (!exitSigns.containsKey(d)) {
			Set<Sign> set = new HashSet<Sign>();
			set.add(s);
			exitSigns.put(d, set);
		} else {
			exitSigns.get(d).add(s);
		}
	}

	public String encode() {
		StringBuilder sb = new StringBuilder();
		sb.append(road + ",N" + entranceSigns + ",X" + exitSigns);
		return sb.toString();
	}

	public static Tile decode(String tile) {
		String roadType = tile.substring(0, tile.indexOf(','));
		tile = tile.substring(tile.indexOf(',') + 1);
		String entranceSigns = tile.substring(tile.indexOf('{'), tile.indexOf('}') + 1);
		tile = tile.substring(tile.indexOf('}') + 1);
		String exitSigns = tile.substring(tile.indexOf('{'), tile.indexOf('}') + 1);
		System.out.println(roadType);
		Hashtable<Direction, Set<Sign>> en = decodeSignListThingChangeNamePlease(entranceSigns);
		Hashtable<Direction, Set<Sign>> ex = decodeSignListThingChangeNamePlease(exitSigns);
		Tile t = new Tile();
		t.road = Road.decode(roadType);
		en.forEach((dir, s) -> {
			s.forEach((sign) -> {
				t.addEntranceSign(dir, sign);
			});
		});
		ex.forEach((dir, s) -> {
			s.forEach((sign) -> {
				t.addExitSign(dir, sign);
			});
		});
		return t;
	}

	public static Hashtable<Direction, Set<Sign>> decodeSignListThingChangeNamePlease(String s) {
		s = s.substring(1, s.length() - 1);
		Hashtable<Direction, Set<Sign>> ret = new Hashtable<Direction, Set<Sign>>();
		String[] temps = s.split("],");
		for (int i = 0; i < temps.length; i++) {
			temps[i] = temps[i].replace("[", "").replace("]", "");
			if(temps[i].indexOf('=') != -1)  {
				String dir = temps[i].substring(0, temps[i].indexOf('=')).trim();
				temps[i] = temps[i].substring(temps[i].indexOf('=') + 1);
				String[] signs = temps[i].split(", ");
				Set<Sign> signSet = new HashSet<Sign>();
				for (String sign : signs) {
					signSet.add(Sign.decode(sign));
				}
				Direction d = Direction.valueOf(dir);
				ret.put(d, signSet);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Tile t = new Tile();
		t.addEntranceSign(Direction.SOUTH, StopSign.getInstance());
		t.addEntranceSign(Direction.EAST, new TrafficLight());
		t.addEntranceSign(Direction.SOUTH, new MaxSpeedSign(80));
//
//		t.addExitSign(Direction.NORTH, new MinSpeedSign(20));
//		t.addExitSign(Direction.WEST, new TrafficLight());
//		t.addExitSign(Direction.WEST, new MinSpeedSign(10));
		System.out.println(t.encode() + "\n");
		System.out.println(Tile.decode(t.encode()).encode());;

	}
}
