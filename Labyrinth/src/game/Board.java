package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private Timer timer;
	private Player player;
	private Map m;
	private int level = 1;
	private String moveDirection = null;
	private int moveIndex = 0;
	private int count = 0;
	private int score = 0;
	private boolean gotTheKey = false;
	private Enemy enemy1, enemy2, enemy3, enemy4;

	public Board() {
		m = new Map(level);
		player = new Player(1, 1, null, 0);
		enemy1 = new Enemy(1, 9);
		enemy2 = new Enemy(20, 3);
		enemy3 = new Enemy(10, 8);
		enemy4 = new Enemy(19, 11);

		// Thread enemy1 = new Thread(thr1);

		addKeyListener(new ActionsTaken(this));
		setFocusable(true);

		timer = new Timer(10, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void paint(Graphics g) {
		super.paintComponents(g);
		// Thread enemy1 = new Thread();

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
				} else if (m.getMap(x, y).equals("n")) {
					g.drawImage(m.getEnemy(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals("k")) {
					g.drawImage(m.getKey(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals("a")) {
					g.drawImage(m.getApple(), x * 32, y * 32, null);
				}
			}
		}
		count++;
//		System.out.println(count);

		g.drawImage(player.getPlayer(moveDirection, moveIndex), player.getX() * 32, player.getY() * 32, null);
		g.drawImage(enemy1.getEnemy(), enemy1.getX() * 32, enemy1.getY() * 32, null);
		g.drawImage(enemy2.getEnemy(), enemy2.getX() * 32, enemy2.getY() * 32, null);
		g.drawImage(enemy3.getEnemy(), enemy3.getX() * 32, enemy3.getY() * 32, null);
		g.drawImage(enemy4.getEnemy(), enemy4.getX() * 32, enemy4.getY() * 32, null);
		this.drawScore(g);
		
		Random rand = new Random();
		//generating random moves for the bombs: 1 - up, 2 - down, 3 - left, 4 - right
		int movingDir = 1 + rand.nextInt(4);
		if (count == 50) {
			if ((movingDir == 1) && (!m.getMap(enemy1.getX(), enemy1.getY() - 1).equals("."))) {
				enemy1.move(0, -1);
			}
			else if ((movingDir == 2) && (!m.getMap(enemy1.getX(), enemy1.getY() + 1).equals("."))) {
				enemy1.move(0, 1);
			}
			else if ((movingDir == 3) && (!m.getMap(enemy1.getX() - 1, enemy1.getY()).equals("."))) {
				enemy1.move(-1, 0);
			}
			else if ((movingDir == 4) && (!m.getMap(enemy1.getX() + 1, enemy1.getY()).equals("."))) {
				enemy1.move(1, 0);
			}
		}
		if (count == 75) {
			if ((movingDir == 1) && (!m.getMap(enemy2.getX(), enemy2.getY() - 1).equals("."))) {
				enemy2.move(0, -1);
			}
			else if ((movingDir == 2) && (!m.getMap(enemy2.getX(), enemy2.getY() + 1).equals("."))) {
				enemy2.move(0, 1);
			}
			else if ((movingDir == 3) && (!m.getMap(enemy2.getX() - 1, enemy2.getY()).equals("."))) {
				enemy2.move(-1, 0);
			}
			else if ((movingDir == 4) && (!m.getMap(enemy2.getX() + 1, enemy2.getY()).equals("."))) {
				enemy2.move(1, 0);
			}
		}
		if (count == 100) {
			if ((movingDir == 1) && (!m.getMap(enemy3.getX(), enemy3.getY() - 1).equals("."))) {
				enemy3.move(0, -1);
			}
			else if ((movingDir == 2) && (!m.getMap(enemy3.getX(), enemy3.getY() + 1).equals("."))) {
				enemy3.move(0, 1);
			}
			else if ((movingDir == 3) && (!m.getMap(enemy3.getX() - 1, enemy3.getY()).equals("."))) {
				enemy3.move(-1, 0);
			}
			else if ((movingDir == 4) && (!m.getMap(enemy3.getX() + 1, enemy3.getY()).equals("."))) {
				enemy3.move(1, 0);
			}
		}
		if (count ==125) {
			if ((movingDir == 1) && (!m.getMap(enemy4.getX(), enemy4.getY() - 1).equals("."))) {
				enemy4.move(0, -1);
			}
			else if ((movingDir == 2) && (!m.getMap(enemy4.getX(), enemy4.getY() + 1).equals("."))) {
				enemy4.move(0, 1);
			}
			else if ((movingDir == 3) && (!m.getMap(enemy4.getX() - 1, enemy4.getY()).equals("."))) {
				enemy4.move(-1, 0);
			}
			else if ((movingDir == 4) && (!m.getMap(enemy4.getX() + 1, enemy4.getY()).equals("."))) {
				enemy4.move(1, 0);
			}
		}
		if (count > 125) {
			count = 0;
		}
	}

	//create scoring points table
	public void drawScore(Graphics g) {
		g.setColor(Color.BLACK);
		Font myFont = new Font("Comic Sans", Font.ITALIC, 25);
		g.setFont(myFont);
		g.drawString("Level: " + level, 375, 25);
		g.drawString("Score: " + score, 750, 25);
	}

	public void keyPressed(KeyEvent event) {
		// playing with WASD or UP, DOWN, LEFT, RIGHT arrows
		int key = event.getKeyCode();
		//move player up
		if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
			if (!m.getMap(player.getX(), player.getY() - 1).equals(".")
					&& !m.getMap(player.getX(), player.getY() - 1).equals("x")) {
				player.move(0, -1);
				moveDirection = "Up";
				moveIndex++;
				if (moveIndex == 6) {
					moveIndex = 1;
				}
			}
		}
		//move player down
		else if ((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			if (!m.getMap(player.getX(), player.getY() + 1).equals(".")
					&& !m.getMap(player.getX(), player.getY() + 1).equals("x")) {
				player.move(0, 1);
				moveDirection = "Down";
				moveIndex++;
				if (moveIndex == 6) {
					moveIndex = 1;
				}
			}
		}
		//move player left
		else if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
			if (!m.getMap(player.getX() - 1, player.getY()).equals(".")
					&& !m.getMap(player.getX() - 1, player.getY()).equals("x")) {
				player.move(-1, 0);
				moveDirection = "Left";
				moveIndex++;
				if (moveIndex == 6) {
					moveIndex = 1;
				}
			}
		}
		//move player right
		else if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
			if (!m.getMap(player.getX() + 1, player.getY()).equals(".")
					&& !m.getMap(player.getX() + 1, player.getY()).equals("x")) {
				player.move(1, 0);
				moveDirection = "Right";
				moveIndex++;
				if (moveIndex == 6) {
					moveIndex = 1;
				}
			}
		}

		//check if player is on the apple and increase score, if true
		if (m.getMap(player.getX(), player.getY()).equals("a")) {
			m.changeMapField(player.getX(), player.getY(), '0');
			score += 25;
		}
		//check if player is on the key
		if (m.getMap(player.getX(), player.getY()).equals("k")) {
			m.changeMapField(player.getX(), player.getY(), '0');
			gotTheKey = true;
		}

		//check if player collides with bomb		
		boolean enemy1Collision = (player.getX() == enemy1.getX()) && (player.getY() == enemy1.getY());
		boolean enemy2Collision = (player.getX() == enemy2.getX()) && (player.getY() == enemy2.getY());
		boolean enemy3Collision = (player.getX() == enemy3.getX()) && (player.getY() == enemy3.getY());
		boolean enemy4Collision = (player.getX() == enemy4.getX()) && (player.getY() == enemy4.getY());
		if (enemy1Collision || enemy2Collision || enemy3Collision || enemy4Collision) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Would you like to start again?", "YOU ARE DEAD!",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if (level == 1) {
					score = 0;
					JOptionPane.getRootFrame();
					m = new Map(level);
					player = new Player(1, 1, null, 0);
					gotTheKey = false;
				}
				else {
					JOptionPane.getRootFrame();
					m = new Map(level);
					player = new Player(1, 1, null, 0);
					gotTheKey = false;
				}
			} else {
				System.exit(0);
			}
		}

		//check if player is on Exit and he/she has taken the key
		if (level < 2) {
			if (m.getMap(player.getX(), player.getY()).equals("e") && gotTheKey) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Would you like to start the next level?",
						"YOU PASSED THE LEVEL!", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					level++;
					JOptionPane.getRootFrame();
					m = new Map(level);
					player = new Player(1, 1, null, 0);
					enemy1 = new Enemy(1, 9);
					enemy2 = new Enemy(20, 3);
					enemy3 = new Enemy(10, 8);
					enemy4 = new Enemy(19, 11);
					gotTheKey = false;
				}
				else {
					System.exit(0);
				}
			}
			else if (m.getMap(player.getX(), player.getY()).equals("e") && !gotTheKey) {
				JOptionPane.showMessageDialog(null, "You don't have the key. Get the key first");
			}
		}
		else {
			if (m.getMap(player.getX(), player.getY()).equals("e") && gotTheKey) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Would you like to restart the game?",
						"CONGRATULATIONS! YOU WON!!!", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					level = 1;
					score = 0;
					JOptionPane.getRootFrame();
					m = new Map(level);
					player = new Player(1, 1, null, 0);
					gotTheKey = false;
				}
				else {
					System.exit(0);
				}
			}
			else if (m.getMap(player.getX(), player.getY()).equals("e") && !gotTheKey) {
				JOptionPane.showMessageDialog(null, "You don't have the key. Get the key first");
			}
		}

	}

	public void keyReleased(KeyEvent event) {

	}
}