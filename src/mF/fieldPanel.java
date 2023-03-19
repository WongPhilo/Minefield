package src.mF;

import java.awt.*;
import javax.swing.*;
import src.MVC.*;
public class fieldPanel extends AppPanel {
    public fieldPanel(AppFactory factory) {
        super(factory);

        GridLayout lm = new GridLayout(4, 2);
        setLayout(lm);
        JButton NW = new JButton("NW");
        JButton N = new JButton("N");
        JButton NE = new JButton("NE");
        JButton W = new JButton("W");
        JButton E = new JButton("E");
        JButton SW = new JButton("SW");
        JButton S = new JButton("S");
        JButton SE = new JButton("SE");

        buttonAssigner(NW);
        buttonAssigner(N);
        buttonAssigner(NE);
        buttonAssigner(W);
        buttonAssigner(E);
        buttonAssigner(SW);
        buttonAssigner(S);
        buttonAssigner(SE);
    }

    public void buttonAssigner(JButton button) {
        button.addActionListener(this);
        controlPanel.add(button);
    }

    public static void main(String[] args) {
        AppFactory factory = new fieldFactory();
        AppPanel panel = new fieldPanel(factory);
        panel.run(factory);
    }
}
