package chess.pieces;

import chess.Pos;

public class Bishop extends Piece {

    private static int SIZE = 8;

    public Bishop(char color, Pos pos) {
        super(color, 'b', pos);
    }

    @Override
    void addPossibleMoves() {
        for (int i = 0; i < SIZE; i++) {
            possibleMoves.add(current.getMove(i, i));
            possibleMoves.add(current.getMove(i, -i));
            possibleMoves.add(current.getMove(-i, i));
            possibleMoves.add(current.getMove(-i, -i));
        }
    }
    
}
