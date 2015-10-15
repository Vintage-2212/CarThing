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

	public Tile(Road road) {
		entranceSigns = new Hashtable<>();
		exitSigns = new Hashtable<>();
		this.road = road;
	}
	
	public Tile(Direction[] directions) {
		this(new Road(directions));
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
		sb.append(road.encode() + ",N" + entranceSigns + ",X" + exitSigns);
		return sb.toString();
	}

	public static Tile decode(String tile) {
		String roadType = tile.substring(0, tile.indexOf(','));
		tile = tile.substring(tile.indexOf(',') + 1);
		String entranceSigns = tile.substring(tile.indexOf('{'), tile.indexOf('}') + 1);
		tile = tile.substring(tile.indexOf('}') + 1);
		String exitSigns = tile.substring(tile.indexOf('{'), tile.indexOf('}') + 1);
		
		Hashtable<Direction, Set<Sign>> en = decodeSignListThingChangeNamePlease(entranceSigns);
		Hashtable<Direction, Set<Sign>> ex = decodeSignListThingChangeNamePlease(exitSigns);
		Tile t = new Tile(Road.decode(roadType));
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
}
