package src.mF;
import java.awt.*;
public class fieldShape {
    private Field field;
    private int height = 500;
    private int width = 300;
    private int size;
    public fieldShape(Field field, int size) {
        this.field = field;
        this.size = size;
    }
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void draw(Graphics2D gc) {
        Color oldColor = gc.getColor();
        gc.setColor(Color.BLACK);

        int rh = height / size;
        int rw = width / size;
        for (int i = 0; i < size; i++) {
            gc.drawLine(0, i * rh, width, i * rh);
            gc.drawLine(i * rw, 0, i * rw, height);
        }

        gc.setColor(oldColor);
    }
}
