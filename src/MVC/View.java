package src.MVC;
import src.mF.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Observer;

abstract public class View extends JPanel implements Observer {
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
