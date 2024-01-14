package chess.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chess.Controller;
import chess.pieces.Piece;

public class SquareGUI extends JButton {

    private static Color WHITE_SQUARE_BACKGROUND = Color.WHITE;
    private static Color BLACK_SQUARE_BACKGROUND = Color.GRAY;
    private static Color MARKED_BACKGROUND = new java.awt.Color(190, 190, 230);
    private static int DIMENSIONS = 100;
    private static String START_OF_PATH = "/Users/axellangenskiold/Documents/personal-projects/chess/app/src/main/resources/";

    ImageIcon image;
    private int row;
    private int col;
    private Controller controller;
    private boolean isMarked;
    private int originalColor;

    public SquareGUI(int row, int col, int color, Controller controller) {
        this.row = row;
        this.col = col;
        this.controller = controller;
        this.originalColor = color;
        isMarked = false;
        

        addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {

                // Image newImage = image.getImage().getScaledInstance(image.getIconWidth() + 1000, image.getIconHeight() + 1000, Image.SCALE_REPLICATE);
                // Image newImg = image.getImage().getScaledInstance(row, col, color);
                // image = new ImageIcon(newImage);

                isMarked = !isMarked;
                changeColor();
                
            } 
        });

        setFocusable(false);
        setOpaque(true);
        setBorderPainted(false);
        setBackground(intToColor(originalColor));
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
            image = new ImageIcon(START_OF_PATH + "b" + piece.toString() + ".png");
        } else if (piece.isWhite()) {
            image = new ImageIcon(START_OF_PATH + "w" + piece.toString() + ".png");
        } else {
            image = new ImageIcon(START_OF_PATH + "Empty" + ".png");
        }

        setIcon(image);
    }

    private void changeColor() {
        if (isMarked) {
            setBackground(MARKED_BACKGROUND);
        } else {
            setBackground(intToColor(originalColor));
        }
    }
}
