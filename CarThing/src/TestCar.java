import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import car.Car;
import physics.Vector;

public class TestCar {
	static 		double acc = 0;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Car car = new Car(new Vector(300, 300), Math.PI / 2);
		JPanel panel = new JPanel() {
			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				car.draw(g);
			};
		};

		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				boolean apply = true;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					acc = 0.05;
					break;
				case KeyEvent.VK_DOWN:
					acc = -0.05;
					break;
				case KeyEvent.VK_LEFT:
					car.rotateLeft();
					break;
				case KeyEvent.VK_RIGHT:
					car.rotateRight();
					break;
				default:
					apply = false;
				}

			}
		});
		panel.setFocusable(true);
		frame.add(panel);
		frame.setSize(640, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		while (true) {
			panel.repaint();
			car.move(acc);
			acc = 0;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
