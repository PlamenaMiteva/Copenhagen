package game;

import java.awt.*;

import javax.swing.*;

public class Player {
	private int playerX, playerY;
	private Image playerImage;
	private int wins; // Amount of labyrinths passed

	public static boolean goingUp;
	public static boolean goingDown;
	public static boolean goingLeft;
	public static boolean goingRight;

	public Player(int paraX, int paraY, String moveDirection, int moveIndex) {

		ImageIcon image = new ImageIcon(".//images//turtleImagenull0.png");

		goingUp = false;
		goingDown = false;
		goingLeft = false;
		goingRight = false;

		this.playerImage = image.getImage();
		this.playerX = paraX;
		this.playerY = paraY;
		this.wins = 0;
	}

	public Image getPlayer(String moveDirection, int moveIndex) {
		String imageFileName = ".//images/turtleImage" + moveDirection + moveIndex + ".png";
		ImageIcon image = new ImageIcon(imageFileName);
		this.playerImage = image.getImage();
		return playerImage;
	}

	public int getX() {
		return playerX;
	}

	public int getY() {
		return playerY;
	}

	public void move(int x, int y) {
		playerX += x;
		playerY += y;
	}

	public int getWins() {
		return this.wins;
	}
}