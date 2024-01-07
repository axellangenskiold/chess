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
        piece = other;
        piece.setPos(pos);
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
