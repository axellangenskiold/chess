package chess.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import chess.Controller;

public class BoardGUI extends JPanel {

    private static int SIZE = 8;
    private Controller controller;

    public BoardGUI(Controller controller) {
        super(new GridLayout(8,8));
        this.controller = controller;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                add(new SquareGUI(row, col, (row + col) % 2, controller));
            }
        }
    }

    public SquareGUI get(int row, int col) {
        return (SquareGUI) getComponent(row * SIZE + col);
    }
}
