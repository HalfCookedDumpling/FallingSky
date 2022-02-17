package fallingSky;

import java.awt.*;

public class Obstacle {

	private double x;

	private double y;

	private int width;
	
	private int height;

	private double xVel;

	private double yVel;

	public Obstacle () {

		y = 720;

		x = (Math.random() * 780);
		
		width = 300;

		height = 100;

		xVel = 0;

		yVel = -4;

	}

	public Obstacle (double x, double y, int width, int height) {

		this.x = x;

		this.y = y;

		this.width = width;

		this.height = height;

		xVel = 0;

		yVel = -4;

	}


	public void move () {

		if (xVel < 0 && x < 0) {

			xVel = -(xVel); 			

		} else if (xVel > 0 && x > 1080 - width) {

			xVel = -(xVel);

		}

		x += xVel;

		y += yVel;

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

	public int getWidth () {

		return width;

	}

	public int getHeight () {

		return height;

	}

	public void setXVel (double value) {

		xVel = value;

	}

	public void setYVel (double value) {

		yVel = value;

	}

	public void paintObstacle (Graphics g) {


		g.fillRect((int) getX(), (int) getY(), getWidth(), getHeight());


	}

	public boolean isTouchingPlayer (Player p) {

		if (p.getX() + 40 < getX() || p.getX() > getX() + getWidth()) {

			return false;

		}

		if (p.getY() + 40 < getY() || p.getY() > getY() + getHeight()) {

			return false;

		}

		return true;

	}

}