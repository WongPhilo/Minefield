package src.mF;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import src.MVC.*;
public class fieldPanel extends AppPanel {
    public fieldPanel(AppFactory factory) {
        super(factory);

        JButton NW = new JButton("NW");
        JButton N = new JButton("N");
        JButton NE = new JButton("NE");
        JButton W = new JButton("W");
        JButton filler = new JButton("");
        JButton E = new JButton("E");
        JButton SW = new JButton("SW");
        JButton S = new JButton("S");
        JButton SE = new JButton("SE");

        buttonAdder(NW, (ControlPanel) controlPanel);
        buttonAdder(N, (ControlPanel) controlPanel);
        buttonAdder(NE, (ControlPanel) controlPanel);
        buttonAdder(W, (ControlPanel) controlPanel);
        JPanel jp = new JPanel();
        jp.add(filler);
        controlPanel.add(jp);
        buttonAdder(E, (ControlPanel) controlPanel);
        buttonAdder(SW, (ControlPanel) controlPanel);
        buttonAdder(S, (ControlPanel) controlPanel);
        buttonAdder(SE, (ControlPanel) controlPanel);

        controlPanel.setVisible(true);
        this.display();
    }

    public static void buttonAdder(JButton b, ControlPanel p) {
        JPanel jp = new JPanel();
        b.addActionListener((ActionListener) p);
        jp.add(b);
        p.add(jp);
        p.setVisible(true);
    }
    public static void main(String args[]) {
        fieldPanel.run(new fieldFactory());
    }
}
