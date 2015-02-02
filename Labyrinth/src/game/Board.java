package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private Timer timer;
	private Player player;
	private Map m;
//	private Enemy enemy;
	private int level = 1;
	private String moveDirection = null;
	private int moveIndex = 0;

	public Board() {
		m = new Map(level);
		player = new Player(1, 1, null, 0);
//		enemy = new Enemy(5,9);
//		Thread enemy1 = new Thread(thr1);

		addKeyListener(new ActionsTaken(this));
		setFocusable(true);

		timer = new Timer(25, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paintComponents(g);
//		Thread enemy1 = new Thread();

		for (int y = 0; y < 14; y++) {
			for (int x = 0; x < 28; x++) {
				if (m.getMap(x, y).equals("0")) {
					g.drawImage(m.getGround(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals(".")) {
					g.drawImage(m.getWall(), x * 32, y * 32, null);
				} else if (m.getMap(x, y).equals("e")) {
					g.drawImage(m.getExit(), x * 32, y * 32,  null);
				} else if (m.getMap(x, y).equals("x")) {
					g.drawImage(m.getDoor(), x * 32, y * 32, null);
				}else if (m.getMap(x, y).equals("N")) {
					g.drawImage(m.getEnemy(), x * 32, y * 32, null);
				}
			}
		}

		g.drawImage(player.getPlayer(moveDirection, moveIndex), player.getX() * 32, player.getY() * 32, null);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void keyPressed(KeyEvent event) {

		// playing with WASD or UP, DOWN, LEFT, RIGHT arrows
		int key = event.getKeyCode();
		// move up
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
		// move down
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
		// move left
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
		// move right
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

		int dialogButton = JOptionPane.YES_NO_OPTION;
		//if player is on bomb
		if(m.getMap(player.getX(), player.getY()).equals("N")) {
			m.changeMapField(player.getX(), player.getY(), '0');
			int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to start again?", "YOU ARE DEAD!", dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				JOptionPane.getRootFrame();
				m = new Map(level);
				player = new Player(1, 1, null, 0);
			}
			else {
				System.exit(0);
			}
		}
		
		//if player is on Exit
		if (level < 2) {
			if (m.getMap(player.getX(), player.getY()).equals("e")) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to start the next level?", "YOU PASSED THE LEVEL!", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					level++;
					JOptionPane.getRootFrame();
					m = new Map(level);
					player = new Player(1, 1, null, 0);
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			if (m.getMap(player.getX(), player.getY()).equals("e")) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to restart the game?", "CONGRATULATIONS! YOU WON!!!", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					level = 1;
					JOptionPane.getRootFrame();
					m = new Map(level);
					player = new Player(1, 1, null, 0);
				}
				else {
					System.exit(0);
				}
			}
		}
	}

//	public void keyReleased(KeyEvent event) {
//		int key = event.getKeyCode();
//		if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
//			moveDirection = null;
//			moveIndex = 0;
//		}
//		if ((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
//			moveDirection = null;
//			moveIndex = 0;
//		}
//		if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
//			moveDirection = null;
//			moveIndex = 0;
//		}
//		if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
//			moveDirection = null;
//			moveIndex = 0;
//		}
//	}
}