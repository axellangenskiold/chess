package chess.pieces;

import java.util.ArrayList;

import chess.Pos;

public class Pawn extends Piece {

    public Pawn(char color, Pos pos) {
        super(color, 'p', pos);
    }

    @Override
    void addPossibleMoves() {
        if (color.equals('w')) {
            possibleMoves.add(current.getMove(-1, 0));
            possibleMoves.add(current.getMove(-2, 0));
            possibleMoves.add(current.getMove(-1, -1));
            possibleMoves.add(current.getMove(-1, 1));

        } else {
            possibleMoves.add(current.getMove(1,0));
            possibleMoves.add(current.getMove(2,0));
            possibleMoves.add(current.getMove(1,-1));
            possibleMoves.add(current.getMove(1,1));
        }
    }
    
}
