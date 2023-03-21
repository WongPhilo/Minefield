package src.mF;

import java.awt.*;
import javax.swing.*;
import src.MVC.*;
public class fieldPanel extends AppPanel {
    public fieldPanel(AppFactory factory) {
        super(factory);

        GridLayout lm = new GridLayout(3, 3);
        setLayout(lm);
        JButton NW = new JButton("NW");
        JButton N = new JButton("N");
        JButton NE = new JButton("NE");
        JButton W = new JButton("W");
        JButton filler = new JButton("");
        JButton E = new JButton("E");
        JButton SW = new JButton("SW");
        JButton S = new JButton("S");
        JButton SE = new JButton("SE");

        buttonAssigner(NW, this);
        buttonAssigner(N, this);
        buttonAssigner(NE, this);
        buttonAssigner(W, this);
        controlPanel.add(filler);
        buttonAssigner(E, this);
        buttonAssigner(SW, this);
        buttonAssigner(S, this);
        buttonAssigner(SE, this);
    }

    public void buttonAssigner(JButton button, fieldPanel panel) {
        button.addActionListener(panel);
        controlPanel.add(button);
    }
}
