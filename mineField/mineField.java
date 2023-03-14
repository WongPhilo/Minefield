class Field extends Model {
	//app goes here
}


class mineFieldFactory implements AppFactory {
	//factory goes here
}

public class mineField {
	public static void main(String args[]) {
		AppPanel.run(new mineFieldFactory());
	}
}