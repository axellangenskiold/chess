package chess.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SquareGUI extends JButton {

    private static Color WHITE_SQUARE_BACKGROUND = Color.WHITE;
    private static Color BLACK_SQUARE_BACKGROUND = Color.GRAY;

    ImageIcon image;
    private int row;
    private int col;

    public SquareGUI(int row, int col, int color) {
        this.row = row;
        this.col = col;

        //setOpaque(false);
        setBackground(intToColor(color));
        setPreferredSize(new Dimension(50, 50));
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

    public void setPiece(String s) {
        setIcon(new ImageIcon("/Users/axellangenskiold/Documents/personal-projects/chess/app/src/main/resources/Bishop.png"));
    }
}
