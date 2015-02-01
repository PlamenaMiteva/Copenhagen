package game;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Labyrinth extends JFrame {
	
	public Labyrinth() {
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Labyrinth");
		setSize(900, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Labyrinth();
	}
}