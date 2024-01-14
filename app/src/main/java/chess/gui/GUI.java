package chess.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import java.awt.Component;

import java.awt.event.MouseListener;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import chess.Controller;
import chess.Pos;

public class GUI extends JFrame {

    private static int SIZE = 8;
    
    private Controller controller;
    private BoardGUI board;
    private SquareGUI from;
    private SquareGUI to;


    public GUI(Controller controller) {
        this.controller = controller;

        board = new BoardGUI(controller);

        add(BorderLayout.CENTER, board);

        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent event) {
                from = (SquareGUI) event.getComponent();
                System.out.println("pressed : " + ((SquareGUI) event.getComponent()).getText());
            }
            @Override
            public void mouseReleased(MouseEvent event) {
                to = (SquareGUI) event.getComponent();
    
                if (from != null && to != null) {
                    Pos newFrom = new Pos(from.getRow(), from.getCol());
                    Pos newTo = new Pos(to.getRow(), to.getCol());
    
                    controller.move(newFrom, newTo);
                }
    
                System.out.println("Release ... first: " + from.getText());
                System.out.println("Release ... last entered: " + to.getText());
            }
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

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
