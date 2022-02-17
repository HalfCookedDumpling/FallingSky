package fallingSky;

import java.awt.*;

public class HoleInTheWall extends Obstacle {

	private Obstacle rightO;

	public HoleInTheWall () {

		super(0, 720, (int) (Math.random() * 780) + 100, 100);

		int leftWidth = this.getWidth();

		rightO = new Obstacle(leftWidth + 100, 720, 1080 - leftWidth - 100, 100);

	}

	public void move() {

		super.move();

		rightO.move();

	}

	public Obstacle getRightSide () {

		return rightO;

	}

	public void setYVel (double value) {

		super.setYVel(value);

		rightO.setYVel(value);

	}

	public void paintObstacle (Graphics g) {

		super.paintObstacle(g);

		rightO.paintObstacle(g);

	}

	public boolean isTouchingPlayer (Player p) {

		if (super.isTouchingPlayer(p) == true) {

			return true;

		}

		if (rightO.isTouchingPlayer(p) == true) {

			return true;

		}

		return false;
		

	}


}