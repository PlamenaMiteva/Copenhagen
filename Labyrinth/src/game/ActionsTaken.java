package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ActionsTaken extends KeyAdapter {
	Board board;
	public ActionsTaken(Board board){
		this.board=board;
	}
	public void keyPressed(KeyEvent event) {
		board.keyPressed(event);
	}
}
