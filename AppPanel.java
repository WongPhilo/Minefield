package tg;

import tools.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class AppPanel  extends JPanel implements ActionListener {
    private Turtle t;
    private ControlPanel controls;
    private CanvasView view;
    private String savedName = "";
    public AppPanel() {
        // create model, install controls & view
        t = new Turtle();
        view = new CanvasView(t);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
        // create my frame with menus and display it
        SafeFrame frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("Turtle Graphics");
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"North", "East", "West", "South", "Clear", "Pen", "Color", "steps"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "North": {
                    t.setHeading(Heading.NORTH);
                    break;
                }

                case "East": {
                    t.setHeading(Heading.EAST);
                    break;
                }

                case "West": {
                    t.setHeading(Heading.WEST);
                    break;
                }

                case "South": {
                    t.setHeading(Heading.SOUTH);
                    break;
                }

                case "Clear": {
                    t.clear();
                    break;
                }

                case "Pen": {
                    t.setPen(t.getPenUp());
                    break;
                }

                case "Color": {
                    Color newColor = JColorChooser.showDialog(null, "Choose a color", t.getColor());
                    t.setColor(newColor);
                    break;
                }

                case "Save": {
                    String fName = Utilities.getFileName((String) null, true, savedName);
                    savedName = fName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.t);
                    os.close();
                    break;
                }

                case "SaveAs": {
                    String fName = JOptionPane.showInputDialog("What name would you like to save as?");
                    savedName = fName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.t);
                    os.close();
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.openFileName((String) null, true);;
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        t = (Turtle) is.readObject();
                        view.setTurtle(t);
                        is.close();
                    }

                    break;

                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        t = new Turtle();
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
                    Utilities.inform("Philo Wong - Turtle Graphics - 2023");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                            "North: orients turtle north", "East: orients turtle east", "West: orients turtle west",
                            "South: orients turtle south", "Clear: clears canvas", "Pen: toggles pen up or down",
                            "Color: changes the color of the pen", "Steps: moves turtle along # of steps"
                    };
                    Utilities.inform(cmmds);
                    break;

                }

                case "steps": {
                    try {
                        int moveSteps = Integer.parseInt(JOptionPane.showInputDialog("how far?"));
                        if (moveSteps <= 0) {
                            throw new NumberFormatException();
                        } else {
                            t.move(moveSteps);
                        }
                    } catch (Exception ex) {
                        Utilities.stepsError(ex);
                    }

                    break;
                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex); // all error handling done here!
        }
    }
    class ControlPanel extends JPanel {
        public ControlPanel() {
            setBackground(Color.PINK);
            FlowLayout lm = new FlowLayout(FlowLayout.CENTER);
            setLayout(lm);
            JButton north = new JButton("North");
            JButton east = new JButton("East");
            JButton west = new JButton("West");
            JButton south = new JButton("South");
            JButton clear = new JButton("Clear");
            JButton pen = new JButton("Pen");
            JButton color = new JButton("Color");
            JLabel stepsLabel = new JLabel("# steps:");
            JTextField steps = new JTextField("0", 10);
            stepsLabel.setLabelFor(steps);
            north.addActionListener(AppPanel.this);
            east.addActionListener(AppPanel.this);
            west.addActionListener(AppPanel.this);
            south.addActionListener(AppPanel.this);
            clear.addActionListener(AppPanel.this);
            pen.addActionListener(AppPanel.this);
            color.addActionListener(AppPanel.this);
            steps.addActionListener(e -> {
                try {
                    int moveSteps = Integer.parseInt(steps.getText());
                    if (moveSteps <= 0) {
                        throw new NumberFormatException();
                    } else {
                        t.move(moveSteps);
                    }
                } catch (Exception ex) {
                    Utilities.stepsError(ex);
                }
            });
            add(north);
            add(east);
            add(west);
            add(south);
            add(clear);
            add(pen);
            add(color);
            add(stepsLabel);
            add(steps);
        }
    }

    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}