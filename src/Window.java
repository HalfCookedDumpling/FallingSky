package fallingSky;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

	private JFrame window;

	private int screen;

	private int titleX;
	
	private int titleY;

	private Player p;

	private Obstacle obstacle;

	private int score;

	public Window() {

		window = new JFrame();

		window.setVisible(true);

		window.setResizable(false);

		window.setFocusable(true);

		window.setBackground(new Color(120, 200, 255));

		window.getContentPane().setBackground(new Color(120, 220, 255));

		window.setTitle("Falling Sky");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setSize(1086, 755);

		window.add(this);

		screen = 0;

		titleX = 220;

		titleY = -20;

	}

	public void setScreen (int screenNumber) {

		screen = screenNumber;

	}

	public void setScore (int score) {

		this.score = score;

	}

	public void paintComponent (Graphics g) {

		if (screen == 0) {

			paintTitleScreen(g);

		} else if (screen == 1) {

			paintGame(g);

		}


	}

	public void setPlayer (Player p) {

		this.p = p;

		this.addKeyListener(p);

		window.addKeyListener(p);

	}

	public void setObstacle (Obstacle o) {

		obstacle = o;

	}

	private void paintTitleScreen(Graphics g) {

		g.setColor(new Color(120, 200, 255));

		g.fillRect(0, 0, 1080, 720);

		g.setColor(new Color(150, 150, 150));
		
		g.fillRect(440, 400, 200, 80);

		g.setColor(Color.WHITE);

		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));

		g.drawString("Start", 470, 460);

		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

		g.drawString("A HalfCookedDumpling Creation", 235, 680);

		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));

		g.drawString("Falling Sky", titleX, titleY);

		if (titleY < 280) {

			titleY += 5;

		}

	}

	private void paintGame (Graphics g) {

		g.setColor(new Color(120, 200, 255));

		g.fillRect(0, 0, 1080, 720);

		g.setColor(new Color(150, 150, 150));

		g.fillRect((int) p.getX(), (int) p.getY(), 40, 40);

		if (obstacle != null) {

			g.setColor(Color.RED);

			obstacle.paintObstacle(g);
		}

		g.setColor(Color.WHITE);

		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

		g.drawString("Score: " + score, 10, 30);

	}


}