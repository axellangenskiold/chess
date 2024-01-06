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

    public void move(Pos from, Pos to) {
        if (contains(possibleMoves, new Move(from, to))) {
            return; //need to be fixed
        }
    }

    public boolean contains(Move[] array, Move move) {
        for (Move other : array) {
            if (other.equals(move)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
