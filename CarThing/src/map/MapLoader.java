package map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapLoader {

	public static final String SEPARATOR = " ";

	public static Map load(File f) throws IOException {
		List<Tile[]> tilesList = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = in.readLine()) != null) {
				String[] tileStrings = line.split(SEPARATOR);
				Tile[] row = new Tile[tileStrings.length];
				for (int i = 0; i < row.length; i++) {
					row[i] = Tile.decode(tileStrings[i]);
				}
				tilesList.add(row);

			}
			Tile[][] tiles = new Tile[tilesList.size()][tilesList.get(0).length];
			for (int y = 0; y < tiles.length; y++) {
				for (int x = 0; x < tiles[y].length; x++) {
					tiles[y][x] = tilesList.get(y)[x];
				}
			}
			return new Map(tiles);
		}
	}
}
