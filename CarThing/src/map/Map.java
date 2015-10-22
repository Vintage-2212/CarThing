package map;

import java.net.NetworkInterface;

public class Map {

	private Tile[][] tiles;

	public Map(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public String encode() {
		StringBuilder sb =  new StringBuilder();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				sb.append(tiles[i][j].encode() + "::");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static Map decode(String code) {
		String[] rows = code.split("\n");
		Tile[][] tiles = new Tile[rows.length][];
		for (int i = 0; i < rows.length; i++) {
			String[] tileCodes = rows[i].split("::");
			tiles[i] = new Tile[tileCodes.length];
			for (int j = 0; j < tileCodes.length; j++) {
				tiles[i][j] = Tile.decode(tileCodes[j]);
			}
		}
		return new Map(tiles);
	}
	
	public Tile get(int i, int j){
		return tiles[i][j];
	}
	
	public int getSize(int index){
		if(index == 1){
			return tiles.length;
		} else if (index == 2){
			return tiles[0].length;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getWidth(){
		return getSize(2);
	}
	
	public int getHeight(){
		return getSize(1);
	}
	
}
