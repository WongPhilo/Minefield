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
    Mine[][] mineview;
    public fieldView(Field m) {
        super(m);
        int dim = size;
        mineview = new Mine[dim][dim];
        setLayout(new GridLayout(dim, dim));
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                mineview[row][col] = m.mines[row][col];
                mineview[row][col].setText("?");
                mineview[row][col].setBorder(BorderFactory.createLineBorder(Color.black));

                this.add(mineview[row][col]);
            }
        }
    }

    //display to user to the screen, display mineField (code) grid 2020
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Field field = (Field)model;

        gc.setColor(oldColor);
    }

}

