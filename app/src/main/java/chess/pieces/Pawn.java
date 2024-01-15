package chess.pieces;

import chess.Pos;

public class Pawn extends Piece {

    public Pawn(char color, Pos pos) {
        super(color, 'p', pos);
    }

    @Override
    void addPossibleMoves() {
        if (color.isWhite()) {
            //for white
            possibleMoves.add(current.getMove(-1, 0));
            possibleMoves.add(current.getMove(-2, 0));
            possibleMoves.add(current.getMove(-1, -1));
            possibleMoves.add(current.getMove(-1, 1));

        } else {
            //for black
            possibleMoves.add(current.getMove(1,0));
            possibleMoves.add(current.getMove(2,0));
            possibleMoves.add(current.getMove(1,-1));
            possibleMoves.add(current.getMove(1,1));
        }
    }

    public boolean isOnStartingRow() {
        return (color.isWhite() && current.getRow() == 6) || (color.isBlack() && current.getRow() == 1);
    }
}
