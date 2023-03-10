package tg;

import javax.swing.*;
import java.awt.*;

public class TestShape extends JComponent {
    private Turtle turtle = new Turtle();
    private TurtleShape ts = new TurtleShape(turtle, 100);

    public void paintComponent(Graphics gc) {
        Graphics2D gc2d = (Graphics2D)gc;
        ts.draw(gc2d);
        gc2d.drawRect(ts.xc, ts.yc, ts.size, ts.size);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("Turtle Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        // create custom component:
        TestShape component = new TestShape();
        frame.add(component);
        frame.setVisible(true);
    }
}
