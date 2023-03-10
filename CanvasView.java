package tg;

import tools.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class CanvasView extends JPanel implements Subscriber {

    private Turtle turtle; // model

    public CanvasView(Turtle t) {
        this.turtle = t;
        t.subscribe(this);
        setSize(World.SIZE, World.SIZE);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.WHITE);
    }

    public void update() { repaint(); }
    public void setTurtle(Turtle newTurtle) {
        turtle.unSubscribe(this);
        turtle = newTurtle;
        turtle.subscribe(this);
        repaint();
    }

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
}
