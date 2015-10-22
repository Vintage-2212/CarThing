package car;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import physics.Vector;

public class Car {

	public static final transient long dt = 30;

	Vector location;
	double speed, alphaWheel, alphaCar = 0;
	int width = 20, height = 40;
	double CoNsT = 0.3;
	double factor = 1;

	public Car(Vector location, double alphaCar) {
		this.location = location;
		this.alphaCar = alphaCar;
	}

	public void move(double acc) {
		location = location.add(Vector.fromPolar(speed, alphaCar).multiply(dt));
		alphaCar += acc / factor * alphaWheel;
		speed += acc;
	}

	public void move() {
		this.move(0);
	}

	public void rotateRight() {
		alphaWheel += CoNsT;
	}

	public void rotateLeft() {
		alphaWheel -= CoNsT;
	}

	public Polygon getPolygon() {
		AffineTransform t = AffineTransform.getRotateInstance(alphaCar);
		t.translate(location.x, location.y);
		Point2D[] preTrans = { new Point(0, 0), new Point(width, 0), new Point(width, height), new Point(0, height),
				new Point(0, 0) };
		Point2D[] dst = new Point[5];
		t.transform(preTrans, 0, dst, 0, 5);
		int[] xArr = new int[5], yArr = new int[5];
		for (int i = 0; i < dst.length; i++) {
			xArr[i] = (int) dst[i].getX();
			yArr[i] = (int) dst[i].getY();
		}
		return new Polygon(xArr, yArr, dst.length);
	}

	public Rectangle getRectangle() {
		Rectangle rect = new Rectangle((int) location.x, (int) location.y, width, height);
		return rect;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(alphaCar, location.x + width / 2, location.y + height / 2);
		g.setColor(Color.RED);
		g2d.fillRect((int) location.x, (int) location.y, width, height);
	}

}
