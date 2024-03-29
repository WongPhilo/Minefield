package src.MVC;

import javax.swing.*;
import javax.swing.border.Border;
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
    public static int FRAME_WIDTH = 1000;
    public static int FRAME_HEIGHT = 1400;
    private String savedName = "";
    public AppPanel(AppFactory factory) {
        super();
        this.factory = factory;
        this.model = factory.makeModel();
        if (model != null) model.addPropertyChangeListener(this);
        this.view = factory.makeView(model);
        view.setBackground(Color.GRAY);
        controlPanel = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controlPanel);
        this.add(view);

        // create my frame with menus and display it
        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display();
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        result.add(Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this));
        result.add(Utilities.makeMenu("Edit", factory.getEditCommands(), this));
        result.add(Utilities.makeMenu("Help", new String[]{"About", "Help"}, this));
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();

        try {
            if (Arrays.asList(factory.getEditCommands()).contains(cmmd)) {
                factory.makeEditCommand(model, cmmd, this).execute();
            }
        } catch (Exception ex) {
            handleException(ex); // all error handling done here!
        }

        try {
            switch (cmmd) {
                case "Save": {
                    String fName;
                    if(savedName.equals("")){
                        fName = Utilities.getFileName((String) null, false, savedName);
                        savedName = fName;
                    }
                    fName = savedName;
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }

                case "SaveAs": {
                    String fName = Utilities.getFileName((String) null, false, savedName);
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
                        model.initSupport();
                        this.setModel(model);
                        is.close();
                    }

                    break;
                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        model = factory.makeModel();
                        this.setModel(model);
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
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

    protected void handleException(Exception e) {
        Utilities.error(e);
    }
    public void setModel(Model newModel) {
        this.model.removePropertyChangeListener(this);
        this.model = newModel;
        this.model.initSupport(); // defined in Bean
        this.model.addPropertyChangeListener(this);
        this.remove(view);
        this.view = factory.makeView(model); //bandaid solution, but no time!
        view.setBackground(Color.GRAY);
        this.add(view);
        view.setModel(this.model);
        display();
        model.changed();
    }
    public void display() { frame.setVisible(true); }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    protected class ControlPanel extends JPanel implements PropertyChangeListener {
        public ControlPanel() {
            setBackground(Color.LIGHT_GRAY);
            Border blackline = BorderFactory.createLineBorder(Color.black);
            setBorder(blackline);
            setLayout(new GridLayout(3, 3));
            this.setVisible(true);
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            repaint();
        }
    }
}