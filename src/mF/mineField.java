package src.mF;
import src.MVC.*;
class Field extends Model {
	//app goes here
}


abstract class mineFieldFactory implements AppFactory {

	public Model makeModel() {

	}
}

public class mineField {
	public static void main(String args[]) {
		AppPanel.run(new mineFieldFactory());
	}
}