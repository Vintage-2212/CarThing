package graphics;

import java.awt.Graphics;

import javax.swing.JPanel;

import map.Map;

public class MapBoard extends JPanel {

	public static void paintMap(Graphics g, Map map) {
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				g.translate(x * Trump.TILE_WIDTH, y * Trump.TILE_WIDTH);
				map.get(y, x).fill(g);
				g.drawRect(0, 0, Trump.TILE_WIDTH, Trump.TILE_WIDTH);
				g.translate(-x * Trump.TILE_WIDTH, -y * Trump.TILE_WIDTH);
			}
		}
	}
}
