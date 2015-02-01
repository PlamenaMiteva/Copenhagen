package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	private int x, y;
	private Image enemyImage;

	public Enemy(int enemyX, int enemyY) {

		ImageIcon image = new ImageIcon("enemy.png");

		this.enemyImage = image.getImage();
		this.x = enemyX;
		this.y = enemyY;

	}

	public Image getEnemy() {
		return enemyImage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move(int moveX, int moveY) {
		x += moveX;
		y += moveY;
	}

}