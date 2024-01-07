package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Color;
import chess.Pos;

public abstract class Piece {
    
    protected Color color;
    private char type;
    protected Pos current;
    protected ArrayList<Move> possibleMoves;

    public Piece(char color, char type, Pos pos) {
        this.type = type;
        this.color = new Color('w');
        current = pos;
    }

    abstract void addPossibleMoves();

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
        return possibleMoves.size() != 0;
    }

    public List<Move> getPossibleMoves() {
        return possibleMoves;
    }

    public void move(Pos from, Pos to) {
        if (possibleMoves.contains(new Move(from, to))) {
            return; //need to be fixed
        }
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
