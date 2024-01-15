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

    public boolean equals(Move other) {
        return (from.equals(other.from) && to.equals(other.to));
    }

    public String toString() {
        return from.toString() + " to " + to.toString();
    }
}
