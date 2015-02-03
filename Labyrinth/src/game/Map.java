package game;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Map {
	private Scanner input;
	private int size;
	private String[] map; //size is the length of the first line in a map
	private Image ground, wall, exit, door, key, apple;
	int level;

	public Map(int Level) {
		level = Level;
		ImageIcon image = new ImageIcon("./images/ground.png");
		ground = image.getImage();
		image = new ImageIcon("./images/wall.png");
		wall = image.getImage();
		image = new ImageIcon("./images/exit.png");
		exit = image.getImage();
		image = new ImageIcon("./images/door.png");
		door = image.getImage();
		image = new ImageIcon("./images/key.png");
		key = image.getImage();
		image = new ImageIcon("./images/apple.png");
		apple = image.getImage();

		openFile();
		readFile();
		closeFile();
	}

	public Image getGround() {
		return ground;
	}

	public Image getWall() {
		return wall;
	}

	public Image getExit() {
		return exit;
	}

	public Image getDoor() {
		return door;
	}

	public Image getKey() {
		return key;
	}

	public Image getApple() {
		return apple;
	}

	public void openFile() {

		String filename = "./maps/map" + level + ".txt";

		if (level < 3) {  // due to 2 maps
			try {
				input = new Scanner(new File(filename));
			} catch (Exception e) {
				System.out.println("Cannot open map file!!!");
			}
			size = input.nextInt();
			map = new String[size]; 

		}
		else {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Would you Like to start over?", "YOU WON", dialogButton);

			if (dialogResult == JOptionPane.YES_OPTION) {

			} else {
				System.exit(0);

			}
		}
	}
	public void readFile() {

		while (input.hasNext()) {

			for (int i = 0; i < size; i++) {
				map[i] = input.next();
			}
		}
	}

	public void closeFile() {
		input.close();
	}

	public String getMap(int x, int y) {
		String index = map[y].substring(x, x + 1);
		return index;
	}

	public void changeMapField(int x, int y, char letter) {
		map[y] = new String(map[y].substring(0, x) + letter + map[y].substring(x + 1, 28));
	}
}