package src.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class AppPanel extends JPanel implements PropertyChangeListener, ActionListener {
    protected Model model;
    protected AppFactory factory;
    protected View view;
    protected JPanel controlPanel; // not a separate class!
    private SafeFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;
    private String savedName = "";
    public AppPanel(AppFactory factory) {
        super();
        this.factory = factory;
        this.model = factory.makeModel();
        model.addPropertyChangeListener(this);
        this.view = factory.makeView(model);
        controlPanel = new ControlPanel();
        this.add(controlPanel);
        this.add(view);
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
            handleException(ex); // all error handling done here!
        }
    }

    protected void handleException(Exception e) {
        Utilities.error(e);
    }

    public static void run(AppFactory factory) {
        try {
            AppPanel panel = new AppPanel(factory);
            panel.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            // create my frame with menus and display it
            SafeFrame frame = new SafeFrame();
            Container cp = frame.getContentPane();
            cp.add(panel);
            frame.setJMenuBar(panel.createMenuBar());
            frame.setTitle(factory.getTitle());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel.setVisible(true);
        } catch (Exception e) {
            Utilities.error("" + e);
        }
    }
    public void setModel(Model newModel) {
        this.model.removePropertyChangeListener(this);
        this.model = newModel;
        this.model.initSupport(); // defined in Bean
        this.model.addPropertyChangeListener(this);
        view.setModel(this.model);
        model.changed();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
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
    }
}