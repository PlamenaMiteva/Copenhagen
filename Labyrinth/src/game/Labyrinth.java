package game;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Labyrinth extends JFrame {
	
	@SuppressWarnings("static-access")
	public Labyrinth() {
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Laby The Turtle");
		setSize(900, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Labyrinth();
	}
}