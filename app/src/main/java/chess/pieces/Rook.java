package chess.pieces;

import chess.Pos;

public class Rook extends Piece {

    private static int SIZE = 8;

    public Rook(char color, Pos pos) {
        super(color, 'r', pos);
    }

    @Override
    void addPossibleMoves() {
        for (int i = 0; i < SIZE; i++) {
            possibleMoves.add(current.getMove(0, i));
            possibleMoves.add(current.getMove(0, -i));
            possibleMoves.add(current.getMove(i, 0));
            possibleMoves.add(current.getMove(-i, 0));
        }
    }
    
}
