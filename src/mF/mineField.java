package src.mF;
import src.MVC.*;
class Field extends Model {
	//app goes here
}


class mineFieldFactory implements AppFactory {

	public Model makeModel() {

	}
}

public class ChangeCommand extends Command {

	public ChangeCommand(Model model) {
		super(model);
	}

	public void execute() throws Exception {
		if (!(model instanceof Stoplight)) {
			throw new Exception("Model must instantiate Stoplight");
		}
		Stoplight light = (Stoplight)model;
		light.change();
	}
}

public class mineField {
	public static void main(String args[]) {
		AppPanel.run(new mineFieldFactory());
	}
}