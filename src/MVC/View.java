package src.MVC;

import src.mF.*;
import javax.swing.*;
abstract public class View extends JPanel {
    protected Model model;

    public View(Model model) {
        this.model = model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return this.model;
    }
}
