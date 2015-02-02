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
	private int x, y;
	private Image enemyImage;
	BufferedReader reader;
	Writer writer = null;
	private String[] enemyAtmap;


	public Enemy(int enemyX, int enemyY) {

		ImageIcon image = new ImageIcon("enemy.png");

		this.enemyImage = image.getImage();
		this.x = enemyX;
		this.y = enemyY;
		
	//	try {
	//		reader = new BufferedReader(new FileReader("enemyAtmap1.txt"));
	//	} catch (Exception e) {
	//		System.out.println("Cannot open map file!!!");
	//	}
	//	enemyAtmap = new String[14]; 

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