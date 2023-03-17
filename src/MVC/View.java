package src.MVC;

import src.mF.*;
import javax.swing.*;
import java.util.Observer;

abstract public class View extends JPanel implements Observer {
    protected Model model;

    public View(Model model) {
        this.model = model;
    }

    public void setModel(Model model) {
        this.model = model;
        if (model != null) { model.addObserver(this); }
    }

    public Model getModel() {
        return this.model;
    }
}
