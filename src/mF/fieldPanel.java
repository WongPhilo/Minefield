package src.mF;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import src.MVC.*;
public class fieldPanel extends AppPanel {
    public fieldPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new GridLayout(3, 2));

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

        NW.addActionListener(this);
        N.addActionListener(this);
        NE.addActionListener(this);
        W.addActionListener(this);
        E.addActionListener(this);
        SW.addActionListener(this);
        S.addActionListener(this);
        SE.addActionListener(this);

        controlPanel.add(NW);
        controlPanel.add(N);
        controlPanel.add(NE);
        controlPanel.add(W);
        controlPanel.add(E);
        controlPanel.add(SW);
        controlPanel.add(S);
        controlPanel.add(SE);
    }

    public static void main(String[] args) {
        AppFactory factory = new fieldFactory();
        AppPanel panel = new fieldPanel(factory);
        panel.run(factory);
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "NW", "N", "NE", "W", "E", "SW", "S", "SE": {
                    new moveCommand(this.model, cmmd);
                    break;
                }

                case "About": {
                    Utilities.inform(factory.about());
                    break;
                }

                case "Help": {
                    Utilities.inform(factory.getHelp());
                    break;

                }
            }
        } catch (Exception ex) {
            handleException(ex); // all error handling done here!
        }
    }
}
