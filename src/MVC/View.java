package src.MVC;
import src.mF.*;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

abstract public class View extends JPanel implements PropertyChangeListener {


    protected Model model;

    public View(Model m) {
        model = m;
        model.addPropertyChangeListener(this);
    }


    public void setModel(Model newModel) {
        model.removePropertyChangeListener(this);
        model = newModel;
        model.addPropertyChangeListener(this);
        repaint();
    }


    public void propertyChange(PropertyChangeEvent evt ) {
        System.out.println("Property changed in view: REPAINTING");
        repaint();
    }
}