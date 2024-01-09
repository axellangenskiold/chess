package chess.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import chess.Controller;

public class GUI extends JFrame {

    private static int SIZE = 8;
    
    Controller controller;
    BoardGUI board;


    public GUI(Controller controller) {
        this.controller = controller;

        board = new BoardGUI(controller);

        add(BorderLayout.CENTER, board);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    public void readFromBoardStart() throws InterruptedException {
        //makes it look cool in the beginning
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < SIZE; col++) {
                getSquare(row, col).setPiece(controller.getPiece(row, col));;
                Thread.sleep(50);
            }
        }

        for (int row = 6; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                getSquare(row, col).setPiece(controller.getPiece(row, col));;
                Thread.sleep(50);
            }
        }


    }

    public SquareGUI getSquare(int row, int col) {
        return board.get(row, col);
    }
}
