package src.mF;

import java.awt.*;
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

        buttonAdder(NW, this);
        buttonAdder(N, this);
        buttonAdder(NE, this);
        buttonAdder(W, this);
        JPanel jp = new JPanel();
        jp.add(filler);
        controlPanel.add(jp);
        buttonAdder(E, this);
        buttonAdder(SW, this);
        buttonAdder(S, this);
        buttonAdder(SE, this);

        controlPanel.setVisible(true);
        this.display();
    }

    public static void buttonAdder(JButton b, fieldPanel p) {
        JPanel jp = new JPanel();
        b.addActionListener(p);
        jp.add(b);
        p.add(jp);
        p.setVisible(true);
    }
    public static void main(String args[]) {
        fieldPanel.run(new fieldFactory());
    }
}
