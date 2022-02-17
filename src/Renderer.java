package fallingSky;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Renderer implements ActionListener, MouseListener {

	private Timer t;

	private Window w;

	private int screen;

	private Player p;

	private Obstacle obstacle;

	private int score;

	public Renderer() {

		w = new Window();

		screen = 0;

		w.addMouseListener(this);

		t = new Timer(10, this);

		t.start();

	}

	public void actionPerformed (ActionEvent e) {

		if (screen == 1) {

			p.changeVelocity();
			
			p.move();

			if (obstacle == null || obstacle.getY() < 0 - obstacle.getHeight()) {

				int spawnType = (int) (Math.random() * 2);

				double speed = -2 - (score / 100) / 10.0;

				if (score >= 2000) {

					speed = -4;

				}		

				if (spawnType == 0) {

					obstacle = new Obstacle();

					obstacle.setXVel((Math.random() * 10) - 5);

					obstacle.setYVel(speed);
					

				} else if (spawnType == 1) {
			
					obstacle = new HoleInTheWall();
		
					obstacle.setYVel(speed);

				}

				w.setObstacle(obstacle);

			}

			if (obstacle != null) {

				obstacle.move();

				if (p.isTouchingObstacle(obstacle)) {

					screen = 0;
					w.setScreen(0);
					p = null;
					obstacle = null;

				}

			}

			score++;

			w.setScore(score);

		}

		w.repaint();

	}

	public void mouseClicked (MouseEvent e) {

		if (screen == 0) {

			if ((e.getX() > 440 && e.getX() < 640) && (e.getY() > 400 && e.getY() < 480)) {

				screen = 1;

				p = new Player();

				w.setPlayer(p);

				w.setScreen(1);

				score = 0;

				w.setScore(score);

			}

		}

	}

	public void mouseEntered (MouseEvent e) {



	}

	public void mouseExited (MouseEvent e) {



	}

	public void mousePressed (MouseEvent e) {



	}

	public void mouseReleased (MouseEvent e) {



	}

}