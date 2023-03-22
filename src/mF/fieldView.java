package src.mF;

import src.MVC.*;
import src.MVC.Model;

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
        setLayout(new GridLayout(size, size));
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                m.mines[row][col].setText("?");
                if (row == size - 1 && col == size - 1) {
                    m.mines[row][col].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                } else {
                    m.mines[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }

                this.add(m.mines[row][col]);
            }
        }
    }

    @Override
    public void setModel(Model newModel) {
        this.model = newModel;
        reset();
        repaint();
        updateUI();
    }
    public void reset() {
        Field m = (Field)model;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                m.mines[row][col].setText("?");
                if (row == size - 1 && col == size - 1) {
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
        Field field = (Field)model;
        field.mines[field.currentX][field.currentY].setText(String.valueOf(field.mines[field.currentX][field.currentY].getNearby()));
        field.mines[field.currentX][field.currentY].setBorder(BorderFactory.createLineBorder(Color.white));
    }
}

