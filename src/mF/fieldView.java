package src.mF;

import src.MVC.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Observable;

public class fieldView extends View {

    public fieldView(Model field) {
        super(field);

    }

    //display to user to the screen, display mineField (code) grid 2020
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Field field = (Field)model;
        fieldShape shape = new fieldShape(field, field.size);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }

}

