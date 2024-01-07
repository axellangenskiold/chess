package chess.pieces;

import java.util.ArrayList;

import chess.Pos;

public class EmptyPiece extends Piece{
    
    public EmptyPiece(Pos pos) {
        super('e', '_', pos);
        possibleMoves = new ArrayList<>();
    }

    @Override
    void addPossibleMoves() {
        return;
    }
}
