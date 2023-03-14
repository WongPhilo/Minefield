package src.MVC;

import mF.*;
import tools.SafeFrame;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel  extends View implements ActionListener {
    private Turtle t;
    private ControlPanel controls;
    private View view;
    private String savedName = "";
    public AppPanel() {
        mineField mf = new mineField();
        view = new View();
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
        // create my frame with menus and display it
        SafeFrame frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("mineField");
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"NW, N, NE, W, E, SW, S, SE"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "NW": {
                    mf.move(mF.Heading.NW);
                    break;
                }

                case "N": {
                    mf.move(mF.Heading.N);
                    break;
                }

                case "NE": {
                    mf.move(mF.Heading.NE);
                    break;
                }

                case "W": {
                    mf.move(mF.Heading.W);
                    break;
                }

                case "E": {
                    mf.move(mF.Heading.E);
                    break;
                }

                case "SW": {
                    mf.move(mF.Heading.SW);
                    break;
                }

                case "S": {
                    mf.move(mF.Heading.S);
                    break;
                }

                case "SE": {
                    mf.move(mF.Heading.SE);
                    break;
                }

                case "Save": {
                    String fName = Utilities.getFileName((String) null, true, savedName);
                    savedName = fName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.mF);
                    os.close();
                    break;
                }

                case "SaveAs": {
                    String fName = JOptionPane.showInputDialog("What name would you like to save as?");
                    savedName = fName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.mF);
                    os.close();
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        t = (mineField) is.readObject();
                        view.setTurtle(t);
                        is.close();
                    }

                    break;
                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        t = new mineField();
                        view.setTurtle(t);
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform("2023 Spring 2023 CS-151 Sec 02 Team 7 - mineField - 2023");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                            "All four cardinal directions and all four of their composites are represented.",
                            "Move in a certain direction to detect mines and find a safe way out."
                    };
                    Utilities.inform(cmmds);
                    break;

                }
            }
        } catch (Exception ex) {
            Utilities.error(ex); // all error handling done here!
        }
    }
    class ControlPanel extends JPanel {
        public ControlPanel() {
            setBackground(Color.PINK);
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

            NW.addActionListener(AppPanel.this);
            N.addActionListener(AppPanel.this);
            NE.addActionListener(AppPanel.this);
            W.addActionListener(AppPanel.this);
            E.addActionListener(AppPanel.this);
            SW.addActionListener(AppPanel.this);
            S.addActionListener(AppPanel.this);
            SE.addActionListener(AppPanel.this);
            add(NW);
            add(N);
            add(NE);
            add(W);
            add(E);
            add(SW);
            add(S);
            add(SE);
        }
    }
}