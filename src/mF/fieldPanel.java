package src.mF;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import src.MVC.*;
public class fieldPanel extends AppPanel {
    private JButton NW, N, NE, W, filler, E, SE, S, SW;
    public fieldPanel(AppFactory factory) {
        super(factory);

        NW = new JButton("NW");
        N = new JButton("N");
        NE = new JButton("NE");
        W = new JButton("W");
        filler = new JButton("");
        E = new JButton("E");
        SW = new JButton("SW");
        S = new JButton("S");
        SE = new JButton("SE");

        buttonAdder(NW, this, controlPanel);
        buttonAdder(N, this, controlPanel);
        buttonAdder(NE, this, controlPanel);
        buttonAdder(W, this, controlPanel);
        controlPanel.add(filler);
        buttonAdder(E, this, controlPanel);
        buttonAdder(SW, this, controlPanel);
        buttonAdder(S, this, controlPanel);
        buttonAdder(SE, this, controlPanel);

        controlPanel.setVisible(true);
    }

    public static void buttonAdder(JButton b, AppPanel p, JPanel c) {
        b.addActionListener(p);
        c.add(b);
        b.setPreferredSize(new Dimension(50, 50));
    }
    public static void main(String args[]) {
        AppFactory factory = new fieldFactory();
        AppPanel panel = new fieldPanel(factory);
        panel.display();
    }
}
