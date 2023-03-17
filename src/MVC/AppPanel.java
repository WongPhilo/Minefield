package src.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class AppPanel extends JPanel implements ActionListener {
    protected Model model;
    protected View view;
    protected AppFactory factory;
    protected ControlPanel controls;
    private String savedName = "";
    public AppPanel(AppFactory factory) {
        controls = new ControlPanel();
        this.add(controls);
        this.add(view);
        this.factory = factory;
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);
        result.add(Utilities.makeMenu("Edit", factory.getEditCommands(), new EditHandler()));
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        if (Arrays.asList(factory.getEditCommands()).contains(cmmd)) {
            factory.makeEditCommand(model, cmmd);
        } else try {
            switch (cmmd) {
                case "Save": {
                    String fName = Utilities.getFileName((String) null, true, savedName);
                    savedName = fName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }

                case "SaveAs": {
                    String fName = JOptionPane.showInputDialog("What name would you like to save as?");
                    savedName = fName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true, savedName);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        Object o = is.readObject();
                        model = (Model)o;
                        view.setModel(model);
                        is.close();
                    }

                    break;
                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        model = new Model();
                        view.setModel(model);
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
                    break;
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex); // all error handling done here!
        }
    }

    public static void run(AppFactory factory) {
        try {
            AppPanel panel = new AppPanel(factory);
            panel.setSize(800,600);
            // create my frame with menus and display it
            SafeFrame frame = new SafeFrame();
            Container cp = frame.getContentPane();
            cp.add(panel);
            frame.setJMenuBar(panel.createMenuBar());
            frame.setVisible(true);
            panel.setVisible(true);
        } catch(Exception e) {
            Utilities.error("" + e);
        }

    }

    protected class EditHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            // parses edit commands (aka commands specific to mineField, only has move so no special cases)
            String cmmd = e.getActionCommand();
            Command c = factory.makeEditCommand(model, cmmd);
            c.execute();
        }
    }
    protected class ControlPanel extends JPanel {
        public ControlPanel() {
            setBackground(Color.GRAY);
        }

        public void add(JButton button) {
            this.add(button);
        }
    }
}