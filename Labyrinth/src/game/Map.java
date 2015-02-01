package game;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Map {
	public Scanner input;
	public int size;
	public String[] map; //size is the length of the first line in a map
	public Image ground, wall, exit, door;
	int level;

	public Map(int Level) {
		level = Level;
		ImageIcon image = new ImageIcon("ground.png");
		ground = image.getImage();
		image = new ImageIcon("wall.png");
		wall = image.getImage();
		image = new ImageIcon("exit.png");
		exit = image.getImage();
		image = new ImageIcon("door.png");
		door = image.getImage();

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

	public void openFile() {
		
		String filename = "map" + level + ".txt";

		if (level < 5) {  // due to 4 maps in src
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

				new Labyrinth();
			} else {
				System.exit(0);
			
			}
		}
	}

	// try {
	// input = new Scanner(new File("map1.txt"));
	// } catch (Exception e) {
	// System.out.println("Cannot open map file!!!");
	// }
	// }

	public void readFile() {
	

		while (input.hasNext()) {

			for (int i = 0; i < size; i++) {
				map[i] = input.next();
				System.out.println(map[i]);
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
}