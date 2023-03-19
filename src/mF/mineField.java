package src.mF;
import src.MVC.*;
class Field extends Model {
	boolean gameOver = false; //if true, JOptionPane an alert and make a new board when it's dismissed
	public Field() {
		//initialize mines?
	}

	public void move(Heading heading) {
		// if (heading = Heading.NW) .. blah blah blah, move and stuff
	}
}

public class mineField {
	public static void main(String args[]) { fieldPanel.run(new fieldFactory()); }
}