package src.Stoplight;

import src.MVC.*;

public class ChangeCommand extends Command {

    public ChangeCommand(Model model) {
        super(model);
    }

    public void execute() {
        Stoplight light = (Stoplight)model;
        light.change();
    }
}