package src.mF;

import src.MVC.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import static src.MVC.AppPanel.FRAME_HEIGHT;
import static src.MVC.AppPanel.FRAME_WIDTH;
import static src.mF.Field.size;

public class fieldView extends View {
    public fieldView(Field m) {
        super(m);
        int dim = size;
        setLayout(new GridLayout(dim, dim));
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                m.mines[row][col] = m.mines[row][col];
                m.mines[row][col].setText("?");
                if (row == dim - 1 && col == dim - 1) {
                    m.mines[row][col].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else {
                    m.mines[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }

                this.add(m.mines[row][col]);
            }
        }
    }

    //display to user to the screen, display mineField (code) grid 2020
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Field field = (Field)model;
        field.mines[field.currentX][field.currentY].setText(String.valueOf(field.mines[field.currentX][field.currentY].getNearby()));
        field.mines[field.currentX][field.currentY].setBorder(BorderFactory.createLineBorder(Color.white));
        gc.setColor(oldColor);
    }

}

