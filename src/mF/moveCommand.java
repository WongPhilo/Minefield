package src.mF;
import src.MVC.*;
public class moveCommand extends Command {
    private Heading heading;
    public moveCommand(Model field, Heading h) {
        super(field);
        this.heading = h;
    }

    public void execute() {
        Field field = (Field)model;
        field.move(heading);
    }
}