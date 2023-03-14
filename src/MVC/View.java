package src.MVC;

import mF.*;
import tools.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class View extends JPanel implements Subscriber {
    private mineField mF;

    public void setField(mineField nmF) {
        mF.unSubscribe(this);
        mF = nmF;
        mF.subscribe(this);
        repaint();
    }

    public Model getModel() {
        return model;
    }
    public void update() { repaint(); }

    /*
     * Java VM will schedule a call to this. We can't
     * call it because we don't have gc
     */
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        TurtleShape shape = new TurtleShape(turtle);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
