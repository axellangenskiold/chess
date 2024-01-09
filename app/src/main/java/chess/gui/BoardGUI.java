package chess.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class BoardGUI extends JPanel {

    private static int SIZE = 8;

    public BoardGUI() {
        super(new GridLayout(8,8));

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                SquareGUI square = new SquareGUI(row, col, (row + col) % 2);

                square.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) { 
                        System.out.println(square.getRow() + " " + square.getCol());
                    } 
                });
                square.setFocusable(false);
                square.setOpaque(true);
                square.setBorderPainted(false);
                
                add(square);
            }
        }

    }

    public SquareGUI get(int row, int col) {
        return (SquareGUI) getComponent(row * 7 + col);
    }
}
