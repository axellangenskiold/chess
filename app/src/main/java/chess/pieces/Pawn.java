package chess.pieces;

import java.util.ArrayList;

import chess.Pos;

public class Pawn extends Piece {

    public Pawn(char color, Pos pos) {
        super(color, 'p', pos);

        possibleMoves = new ArrayList<>();
    }

    @Override
    void addPossibleMoves() {
        if (color.equals('w')) {
            possibleMoves.add(current.getMove(0, -1));
            possibleMoves.add(current.getMove(0, -2));
        } else {
            possibleMoves.add(current.getMove(0, 1));
            possibleMoves.add(current.getMove(0, 2));
        }
    }
    
}
