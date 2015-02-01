package game;

import java.awt.*;
import javax.swing.*;

public class Player {
	public int playerX, playerY;
	public Image playerImage;
	private int wins; // Amount of labyrinths passed

	public Player() {

		ImageIcon image = new ImageIcon("player.png");
		
		this.playerImage = image.getImage();
		this.playerX = 1;
		this.playerY = 1;
		this.wins = 0;

	}

	public Image getPlayer() {
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