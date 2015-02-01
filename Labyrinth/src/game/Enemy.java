package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	public int x, y;
	public Image enemyImage;

	public Enemy(int enemyX, int enemyY) {

		ImageIcon image = new ImageIcon("enemy.png");

		this.enemyImage = image.getImage();
		this.x = enemyX;
		this.y = enemyY;

	}

	public Image getPlayer() {
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