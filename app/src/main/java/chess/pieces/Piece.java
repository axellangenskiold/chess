package chess.pieces;

import chess.Color;
import chess.Pos;

public abstract class Piece {
    
    private Color color;
    private char type;
    private Move[] possibleMoves;

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

    public  boolean isMovable() {
        return possibleMoves.length != 0;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
