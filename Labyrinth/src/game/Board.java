package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {
	private Timer timer;
	private Player player;
	private Map m;
	private Enemy enemy;
	private int level = 1;

	public Board() {
		m = new Map(level);
		player = new Player(1,1);
		enemy = new Enemy(2,2);


		addKeyListener(new ActionsTaken(this));
		setFocusable(true);

		timer = new Timer(5, this);
		timer.start();
	}
	

	public void paint(Graphics g) {
		super.paintComponents(g);

		for (int y = 0; y < 14; y++) {
			for (int x = 0; x < 28; x++) {
				if (m.getMap(x, y).equals("0")) {
					g.drawImage(m.getGround(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals(".")) {
					g.drawImage(m.getWall(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals("e")) {
					g.drawImage(m.getExit(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals("x")) {
					g.drawImage(m.getDoor(), x * 32, y * 32, null);
				}
				
			}
		}
		g.drawImage(player.getPlayer(), player.getX() * 32, player.getY() * 32,
				null);
		g.drawImage(enemy.getEnemy(), enemy.getX() * 32, enemy.getY() * 32,
				null);
	
	}

	public void actionPerformed(ActionEvent e) {
		
		repaint();
		int dialogButton = JOptionPane.YES_NO_OPTION;
		if (m.getMap(player.getX(), player.getY()).equals("e")) {
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Would you like to start the next level?",
					"YOU PASSED THE LEVEL!", dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				level++;
				JOptionPane.getRootFrame();
				m = new Map(level);

				player = new Player(1,1);
				
			} else {
				System.exit(0);
			}
		}
	}

	public void keyPressed(KeyEvent event) {

		// playing with WASD or UP, DOWN, LEFT, RIGHT arrows
		int key = event.getKeyCode();

		// up
		if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
			if (!m.getMap(player.getX(), player.getY() - 1).equals(".")
					&& !m.getMap(player.getX(), player.getY() - 1).equals(
							"x")) {
				player.move(0, -1);
			}
		}

		// down
		else if ((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			if (!m.getMap(player.getX(), player.getY() + 1).equals(".")
					&& !m.getMap(player.getX(), player.getY() + 1).equals(
							"x")) {
				player.move(0, 1);
			}
		}

		// left
		else if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
			if (!m.getMap(player.getX() - 1, player.getY()).equals(".")
					&& !m.getMap(player.getX() - 1, player.getY()).equals(
							"x")) {
				player.move(-1, 0);
			}
		}
		// right
		else if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
			if (!m.getMap(player.getX() + 1, player.getY()).equals(".")
					&& !m.getMap(player.getX() + 1, player.getY()).equals(
							"x")) {
				player.move(1, 0);
			}
		}
	}
}