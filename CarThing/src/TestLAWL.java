import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.Trump;
import map.Road;

public class TestLAWL extends JPanel {
	
	static int i = 0;
	
	public static void main(String[] args) {
//			Tile[][] t = new Tile[4][4];
//			int i = 0, j = 0;
//			for (char c : "0123456789abcdef".toCharArray()) {
//				if(i == 4) {
//					i = 0;
//					j += 1;
//				}
//				t[i][j] = new Tile(Road.decode(c + ""));
//				i++;
//			}
//			Map m = new Map(t);
//			System.out.println(m.encode().equals(Map.decode(m.encode()).encode()));
		
		TestLAWL t = new TestLAWL();
		JFrame f = new JFrame();
		f.add(t);
		f.setVisible(true);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(3);
		while(i < 16) {
			System.out.println(Arrays.toString(Road.decode(Integer.toHexString(i)).getDirections()));
			t.repaint();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawPolygon(Trump.getPolygonByRoad(Road.decode("F")));
		g.fillPolygon(Trump.getPolygonByRoad(Road.decode(Integer.toHexString(i))));
	}

}
