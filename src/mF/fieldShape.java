package src.mF;
import java.awt.*;
public class fieldShape {
    private Field field;
    private int height, width;
    public fieldShape(Field field, int height, int width) {
        this.field = field;
        this.height = height;
        this.width = width;
    }

    public fieldShape(Field field) {
        this(field, 500, 300);
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

        int rh = height / (20);
        int rw = width / (20);
        for (int i = 0; i < 20; i++) {
            gc.drawLine(0, i * rh, width, i * rh);
            gc.drawLine(i * rw, 0, i * rw, height);
        }

        gc.setColor(oldColor);
    }
}
