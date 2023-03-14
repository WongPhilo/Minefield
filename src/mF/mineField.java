package src.mF;

class Field extends Model {
	//app goes here
}


class mineFieldFactory implements AppFactory {

	public Model makeModel() {

	}
}

public class mineField extends Publisher implements Serializable {
	public static void main(String args[]) {
		AppPanel.run(new mineFieldFactory());
	}
}