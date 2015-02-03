package game;

import java.awt.Image;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Enemy {
	private int enemyX, enemyY;
	private Image enemyImage;
	//	private String[] enemyAtmap;

	public Enemy(int enemyX, int enemyY) {

		ImageIcon image = new ImageIcon("enemy.png");

		this.enemyImage = image.getImage();
		this.enemyX = enemyX;
		this.enemyY = enemyY;
	}

	public Image getEnemy() {
		return enemyImage;
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