package graphics;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import booah.Direction;
import booah.Road;

public class Trump {

	public static final int ROAD_WIDTH = 20;
	public static final int TILE_WIDTH = 100;

	public static Polygon getPolygonByRoad(Road road) {
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		
		x.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
		y.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
		if (road.contains(Direction.EAST)) {
			x.add(0);
			y.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
			
			x.add(0);
			y.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
		}
		x.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
		y.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
		if (road.contains(Direction.NORTH)) {
			x.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
			y.add(0);
			
			x.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
			y.add(0);
		}
		x.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
		y.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
		if (road.contains(Direction.WEST)) {
			x.add(TILE_WIDTH);
			y.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
			
			x.add(TILE_WIDTH);
			y.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
		}
		x.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
		y.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
		if (road.contains(Direction.SOUTH)) {
			x.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
			y.add(TILE_WIDTH);
			x.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
			y.add(TILE_WIDTH);
		}
		x.add(new Integer((TILE_WIDTH - ROAD_WIDTH) / 2));
		y.add(new Integer((TILE_WIDTH + ROAD_WIDTH) / 2));
		
		int[] xArr = new int[x.size()];
		for (int i = 0; i < xArr.length; i++) {
			xArr[i] = x.get(i);
		}
		int[] yArr = new int[y.size()];
		for (int i = 0; i < yArr.length; i++) {
			yArr[i] = y.get(i);
		}
		
		return new Polygon(xArr, yArr, xArr.length);
	}

}
