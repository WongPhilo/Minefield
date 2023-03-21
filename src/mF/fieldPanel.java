package src.mF;

import java.awt.*;
import javax.swing.*;
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

        controlPanel.add(NW);
        controlPanel.add(N);
        controlPanel.add(NE);
        controlPanel.add(W);
        controlPanel.add(filler);
        controlPanel.add(E);
        controlPanel.add(SW);
        controlPanel.add(S);
        controlPanel.add(SE);

        NW.addActionListener(this);
        N.addActionListener(this);
        NE.addActionListener(this);
        W.addActionListener(this);
        E.addActionListener(this);
        SW.addActionListener(this);
        S.addActionListener(this);
        SE.addActionListener(this);
    }
    public static void main(String args[]) {
        AppPanel field = fieldPanel.run(new fieldFactory());
        field.display();
    }
}
