package src.mF;
import src.MVC.*;
import java.awt.*;
import java.util.Observable;

public class fieldView extends View {
    public fieldView(Model field) { super(field); }
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Field field = (Field)model;
        fieldShape shape = new fieldShape(field);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }
}
