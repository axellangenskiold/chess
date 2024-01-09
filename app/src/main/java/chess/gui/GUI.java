package chess.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import chess.Controller;

public class GUI extends JFrame {

    private static int SIZE = 8;
    
    Controller controller;
    BoardGUI board;


    public GUI(Controller controller) {
        this.controller = controller;

        board = new BoardGUI();

        add(BorderLayout.CENTER, board);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    public void readFromBoard() {
        for (int row = SIZE; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                getSquare(row,col).setPiece(controller.getPiece(row, col));
            }
        }
    }

    public SquareGUI getSquare(int row, int col) {
        return board.get(row, col);
    }
}
