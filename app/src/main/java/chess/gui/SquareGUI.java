package chess.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chess.Controller;
import chess.pieces.Piece;

public class SquareGUI extends JButton {

    private static Color WHITE_SQUARE_BACKGROUND = Color.WHITE;
    private static Color BLACK_SQUARE_BACKGROUND = Color.GRAY;
    private static int DIMENSIONS = 100;
    private static String START_OF_PATH = "/Users/axellangenskiold/Documents/personal-projects/chess/app/src/main/resources/";

    ImageIcon image;
    private int row;
    private int col;
    private Controller controller;

    public SquareGUI(int row, int col, int color, Controller controller) {
        this.row = row;
        this.col = col;
        this.controller = controller;

        addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                setPiece(controller.getPiece(getRow(), getCol()));
            } 
        });

        //addMouseListener(new HoverMouseListener(image));

        setFocusable(false);
        setOpaque(true);
        setBorderPainted(false);
        setBackground(intToColor(color));
        setPreferredSize(new Dimension(DIMENSIONS, DIMENSIONS));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Color intToColor(int code) {
        if (code == 0) {
            return WHITE_SQUARE_BACKGROUND;
        }
        return BLACK_SQUARE_BACKGROUND;
    }

    public void setPiece(Piece piece) {
        if (piece.isBlack()) {
            setIcon(new ImageIcon(START_OF_PATH + "b" + piece.toString() + ".png"));
        } else if (piece.isWhite()) {
            setIcon(new ImageIcon(START_OF_PATH + "w" + piece.toString() + ".png"));
        } else {
            setIcon(new ImageIcon(START_OF_PATH + "Empty" + ".png"));
        }
    }
}
