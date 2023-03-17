package src.mF;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import src.MVC.*;
public class fieldPanel extends AppPanel {
    public fieldPanel(AppFactory factory) {
        super(factory);
        controls.setLayout(new GridLayout(3, 2));

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

        controls.add(NW);
        controls.add(N);
        controls.add(NE);
        controls.add(W);
        controls.add(E);
        controls.add(SW);
        controls.add(S);
        controls.add(SE);
    }

    public static void main(String[] args) {
        AppFactory factory = new fieldFactory();
        AppPanel panel = new fieldPanel(factory);
        panel.run(factory);
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        if (factory.makeEditCommand(this.model, cmmd) != null) return;
        try {
            switch (cmmd) {
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
            Utilities.error(ex); // all error handling done here!
        }
    }
}
