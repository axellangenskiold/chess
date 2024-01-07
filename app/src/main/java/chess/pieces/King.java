package chess.pieces;

import chess.Pos;

public class King extends Piece {

    public King(char color, Pos pos) {
        super(color, 'K', pos);
    }

    @Override
    void addPossibleMoves() {
        possibleMoves.add(current.getMove(1, 1));
        possibleMoves.add(current.getMove(1, -1));
        possibleMoves.add(current.getMove(-1, 1));
        possibleMoves.add(current.getMove(-1, -1));

        possibleMoves.add(current.getMove(1, 0));
        possibleMoves.add(current.getMove(-1, 0));
        possibleMoves.add(current.getMove(0, 1));
        possibleMoves.add(current.getMove(0, -1));
    }
    
}
