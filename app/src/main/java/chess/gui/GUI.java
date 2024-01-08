package chess.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import chess.Controller;

public class GUI extends JFrame {
    
    Controller controller;

    public GUI(Controller controller) {
        this.controller = controller;

        BoardGUI board = new BoardGUI();

        add(BorderLayout.CENTER, board);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
}
