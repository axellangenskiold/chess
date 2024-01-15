package chess.pieces;

import chess.Pos;

public class Move {

    Pos from;
    Pos to;
    public Move(Pos from, Pos to) {
        this.from = from;
        this.to = to;
    }

    public boolean isOutOfBounds() {
        return to.isOutOfBounds() || from.isOutOfBounds();
    }

    public Pos getTo() {
        return to;
    }

    public Pos getFrom() {
        return from;
    }

    public boolean equals(Move other) {
        return (from.equals(other.from) && to.equals(other.to));
    }

    public boolean isDiagonal() {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());

        return rowDiff == colDiff;
    }

    //checks if a move is more than one step in either direction
    public boolean isDoubleOrMore() {
        return (Math.abs(to.getRow() - from.getRow()) > 1) || 
        (Math.abs(to.getCol() - from.getCol()) > 1);
    }

    public String toString() {
        return from.toString() + " to " + to.toString();
    }
}
