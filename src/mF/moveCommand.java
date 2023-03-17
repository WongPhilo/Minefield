package src.mF;
import src.MVC.*;
public class moveCommand extends Command {

    public moveCommand(Model field, String cmmd) {
        super(field);
    }

    public void execute(String cmmd) {
        Field field = (Field)model;
        try {
            switch (cmmd) {
                case "NW": {
                    field.move(Heading.NW);
                    break;
                }

                case "N": {
                    field.move(Heading.N);
                    break;
                }

                case "NE": {
                    field.move(Heading.NE);
                    break;
                }

                case "W": {
                    field.move(Heading.W);
                    break;
                }

                case "E": {
                    field.move(Heading.E);
                    break;
                }

                case "SW": {
                    field.move(Heading.SW);
                    break;
                }

                case "S": {
                    field.move(Heading.S);
                    break;
                }

                case "SE": {
                    field.move(Heading.SE);
                    break;
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex); // all error handling done here!
        }
    }
}
