package src.MVC;

import src.mF.mineField;

public abstract class Command {
    protected Model model;
    public Command(Model model) {
        this.model = model;
    }
    public void execute(){}
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
