package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Color;
import chess.Pos;

public abstract class Piece {

    public static char PAWN = 'p';
    public static char KING = 'k';
    public static char QUEEN = 'q';
    public static char KNIGHT = 'n';
    public static char ROOK = 'r';
    public static char BISHOP = 'b';
    
    private char type;
    protected Color color;
    protected Pos current;
    protected List<Move> possibleMoves;
    protected boolean canJump = false;

    public Piece(char color, char type, Pos pos) {
        this.type = type;
        this.color = new Color(color);
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

    public char type() {
        return type;
    }

    public boolean isEmptySquare() {
        return color.isEmpty();
    }

    public boolean isSameColor(Piece other) {
        return color.equals(other.color);
    }

    //only gives opposite for white and black, always false for Empty
    public boolean isOppositeColor(Piece other) {
        return (isWhite() && other.isBlack()) || (isBlack() && other.isWhite());
    }

    public boolean canJump() {
        return canJump;
    }

    public List<Move> getPossibleMoves() {
        possibleMoves.removeIf(move -> move.isOutOfBounds());
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
        addPossibleMoves();
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
