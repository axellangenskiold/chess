package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Color;
import chess.Pos;

public abstract class Piece {
    
    protected Color color;
    private char type;
    protected Pos current;
    protected List<Move> possibleMoves;

    public Piece(char color, char type, Pos pos) {
        this.type = type;
        this.color = new Color('w');
        current = pos;
        possibleMoves = new ArrayList<>();
        addPossibleMoves();
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

    public boolean isPossibleMove(Move move) {
        for (int i = 0; i < possibleMoves.size(); i++) {
            if (possibleMoves.get(i).equals(move)) {
                return true;
            }
        }
        return false;
    } 

    public Pos getPos() {
        return current;
    }

    public void setPos(Pos pos) {
        current = pos;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
