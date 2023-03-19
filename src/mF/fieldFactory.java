package src.mF;

import src.MVC.*;

public class fieldFactory implements AppFactory {

    public Model makeModel() {
        return new Field();
    }
    @Override
    public View makeView(Model m) {
        return new fieldView((Field)m);
    }

    @Override
    public Command makeEditCommand(Model model, String type) {
        if (type == "Move") { return new moveCommand(model, type); }
        return null;
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"NW", "N", "NE", "W", "E", "SW", "S", "SE"};
    }

    @Override
    public String getTitle() {
        return "Minefield";
    }

    @Override
    public String getHelp() {
        return new String("All four cardinal directions and all four of their composites are represented. " +
                "Move in a certain direction to detect mines and find a safe way out. " +
                "The goal is to reach the bottom-right corner without setting off any mines.");
    }

    @Override
    public String about() {
        return new String("2023 Spring 2023 CS-151 Sec 02 Team 7 - mineField - 2023");
    }
}
