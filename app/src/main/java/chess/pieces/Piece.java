package chess.pieces;

import chess.Color;

public abstract class Piece {

    Color color;
    char type;

    public Piece(char color, char type) {
        this.type = type;
        this.color = new Color('w');
    }

    public boolean isWhite() {
        return color.isWhite();
    }

    public boolean isBlack() {
        return color.isBlack();
    }

    public boolean isEmptySquare() {
        return color.isEmpty();
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }

}
