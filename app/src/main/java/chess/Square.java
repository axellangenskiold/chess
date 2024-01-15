package chess;

import chess.pieces.*;

public class Square {

    private Piece piece;
    private Pos pos;
    
    public Square(Pos pos) {
        this(pos, new EmptyPiece(pos));
    }

    public Square(Pos pos, Piece piece) {
        this.pos = pos;
        this.piece = piece;
    }

    public void setPiece(Piece other) {
        System.out.println("Pos before: " + other.getPos().toString());
        piece = other;
        other.setPos(pos);
        piece.setPos(pos);
        System.out.println("Pos after: " + other.getPos().toString());
    }

    public Piece getPiece() {
        return piece;
    }

    public void setToEmpty() {
        piece = new EmptyPiece(pos);
    }

    @Override
    public String toString() {
        return piece.toString();
    }
}
