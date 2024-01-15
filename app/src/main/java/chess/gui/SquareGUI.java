package chess.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import chess.Controller;
import chess.pieces.Piece;

public class SquareGUI extends JButton {

    private static Color WHITE_SQUARE_BACKGROUND = Color.WHITE;
    private static Color BLACK_SQUARE_BACKGROUND = Color.GRAY;
    private static Color MARKED_BACKGROUND = new java.awt.Color(190, 190, 230);
    private static int DIMENSIONS = 80;
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

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                ((BoardGUI) getParent()).setFromSquare(row, col);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ((BoardGUI) getParent()).execute();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMarked = !isMarked;
                changeColor();
                ((BoardGUI) getParent()).setToSquare(row, col);
            }

            @Override
            public void mouseExited(MouseEvent e) {
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
