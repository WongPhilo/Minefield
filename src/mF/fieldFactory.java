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
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "NW": {
                return new moveCommand(model, Heading.NW);
            }

            case "N": {
                return new moveCommand(model, Heading.N);
            }

            case "NE": {
                return new moveCommand(model, Heading.NE);
            }

            case "W": {
                return new moveCommand(model, Heading.W);
            }

            case "E": {
                return new moveCommand(model, Heading.E);
            }

            case "SW": {
                return new moveCommand(model, Heading.SW);
            }

            case "S": {
                return new moveCommand(model, Heading.S);
            }

            case "SE": {
                return new moveCommand(model, Heading.SE);
            }
        }

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
                "The goal is to reach the bottom-right corner, bordered in green, without setting off any mines.");
    }

    @Override
    public String about() {
        return new String("2023 Spring 2023 CS-151 Sec 02 Team 7 - mineField - 2023");
    }
}
