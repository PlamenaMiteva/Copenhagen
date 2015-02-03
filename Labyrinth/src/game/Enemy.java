package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	private int enemyX, enemyY;
	private static Image enemyImage;
	private static Image exImage;

	@SuppressWarnings("static-access")
	public Enemy(int enemyX, int enemyY) {

		ImageIcon image = new ImageIcon("./images/enemy.png");
		ImageIcon explosion = new ImageIcon("./images/explosion.png");

		this.exImage = explosion.getImage();
		this.enemyImage = image.getImage();
		this.enemyX = enemyX;
		this.enemyY = enemyY;
	}

	public static Image getEnemy(String bomb) {

		if (bomb.equals("boom")) {
			return exImage;
		} else {
			return enemyImage;
		}
	}

	public int getX() {
		return enemyX;
	}

	public int getY() {
		return enemyY;
	}
	
	public void move(int x, int y) {
		enemyX += x;
		enemyY += y;
	}
}