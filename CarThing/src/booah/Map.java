package booah;

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
	
	

}
