import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.MapBoard;
import map.Direction;
import map.Map;
import map.Tile;

public class TestBananasLawl {
	public static void main(String[] args) {																																																	for(int i=0; i<Integer.MAX_VALUE; i++) System.out.println("אני אוהב בולבולים");
		Tile[][] tiles = new Tile[][] {
			{new Tile(Direction.EAST, Direction.SOUTH), new Tile(Direction.WEST, Direction.SOUTH)},
			{new Tile(Direction.EAST, Direction.NORTH), new Tile(Direction.WEST, Direction.NORTH)},
			{new Tile(Direction.EAST, Direction.SOUTH), new Tile(Direction.WEST, Direction.SOUTH)},
			{new Tile(Direction.EAST, Direction.NORTH), new Tile(Direction.WEST, Direction.NORTH)},
			{new Tile(Direction.EAST, Direction.SOUTH), new Tile(Direction.WEST, Direction.SOUTH)},
			{new Tile(Direction.EAST, Direction.NORTH), new Tile(Direction.WEST, Direction.NORTH)}
		};
		JFrame frame = new JFrame();
		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3675121282587554994L;

			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				MapBoard.paintMap(g, new Map(tiles));
				
			};
			
		};
		frame.add(panel);
		frame.setSize(640, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
