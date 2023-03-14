package src.mF;

import src.MVC.*;
public class moveCommand extends Command {

    public moveCommand (Model model) {
        super(model);
    }

    public void execute() throws Exception {
        if (!(model instanceof mineField)) {
            throw new Exception("Model must instantiate mineField!");
        }
        mineField field = (mineField)model;
        field.change();
    }
}
