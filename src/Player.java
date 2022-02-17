package fallingSky;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Player implements KeyListener {

	ArrayList<Integer> keys;

	private double x;

	private double y;

	private double yVel;

	private double xVel;

	private double maxSpeed;

	public Player () {

		keys = new ArrayList<Integer>();

		x = 520;

		y = 200;

		xVel = 0;

		yVel = 0;

		maxSpeed = 10;

	}

	public void keyPressed (KeyEvent e) {

		if (!keys.contains(e.getKeyCode())) {

			keys.add((Integer) e.getKeyCode());

		}

	}

	public void keyTyped (KeyEvent e) {


	}

	public void keyReleased (KeyEvent e) {

		keys.remove((Integer) e.getKeyCode());

	}

	public ArrayList<Integer> getKeys() {

		return keys;

	}

	public double getX () {

		return x;

	} 

	
	public double getY () {

		return y;

	}

	public double getXVel () {

		return xVel;

	}

	public double getYVel () {

		return yVel;

	}

	public void setXVel (double value) {

		xVel = value;

	}

	public void setYVel (double value) {

		yVel = value;

	}

	public void move () {

		if (Math.abs(xVel) > 0.1) {

			x += xVel;

		}

		y += yVel;

	}

	public void stop () {

		xVel = 0;

		yVel = 0;

	}

	public void changeVelocity () {

		if (keys.contains(KeyEvent.VK_A) && x > 0) {


			if (xVel > - (maxSpeed)) {

				xVel -= 0.5;

			} else {

				xVel = - (maxSpeed);

			}

		} else if (keys.contains(KeyEvent.VK_D) && x < 1040) {


			if (xVel < maxSpeed) {

				xVel += 0.5;

			} else {

				xVel = maxSpeed;

			}


		} else {
	
			if (xVel > 0) {

				xVel -= 0.1;

			} else if (xVel < 0) {

				xVel += 0.1;

			} else {

				stop();

			}

		}

		if (x < 0) {

			x = 0;

			stop();

		} else if (x > 1040) {

			x = 1040;

			stop();

		}
	}

	public boolean isTouchingObstacle (Obstacle o) {

		return o.isTouchingPlayer(this);

	}

}