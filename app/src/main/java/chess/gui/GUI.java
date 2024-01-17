package chess.gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import chess.Controller;

@SuppressWarnings("deprecation")
public class GUI extends JFrame implements Observer {

    private static int SIZE = 8;
    
    private Controller controller;
    private BoardGUI board;

    public GUI(Controller controller) {
        this.controller = controller;

        board = new BoardGUI(controller);
        controller.getBoard().addObserver(this);

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

    public void updateGUI() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                getSquare(row, col).setPiece(controller.getPiece(row, col));
            }
        }
    }

    public SquareGUI getSquare(int row, int col) {
        return board.get(row, col);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(".");
        if (arg.equals("executed")) {
            updateGUI();
        } else if (arg.equals("checkMate")) {
            JOptionPane.showConfirmDialog(this, "Check Mate");
        }
    }
}
