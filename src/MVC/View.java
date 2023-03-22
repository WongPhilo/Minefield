package src.MVC;
import src.mF.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static src.MVC.AppPanel.FRAME_HEIGHT;
import static src.MVC.AppPanel.FRAME_WIDTH;

public class View extends JPanel implements PropertyChangeListener {

    protected Model model;
    public View(Model m) {
        this.model = m;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground((Color.WHITE));
        model.addPropertyChangeListener(this);
    }

    public void setModel(Model newModel) {
        this.model = newModel;
        repaint();
    }
    public void propertyChange(PropertyChangeEvent evt ) {
        repaint();
    }
}