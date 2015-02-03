package game;

import java.awt.*;

import javax.swing.*;

public class Player {
	private int playerX, playerY;
	private Image playerImage;

	public Player(int paraX, int paraY, String moveDirection, int moveIndex) {

		ImageIcon image = new ImageIcon("./images/turtleImagenull0.png");

		this.playerImage = image.getImage();
		this.playerX = paraX;
		this.playerY = paraY;
	}

	public Image getPlayer(String moveDirection, int moveIndex) {
		String imageFileName = "./images/turtleImage" + moveDirection
				+ moveIndex + ".png";
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
}