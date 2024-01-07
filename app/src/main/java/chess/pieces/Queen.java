package chess.pieces;

import chess.Pos;

public class Queen extends Piece {

    private static int SIZE = 8;

    public Queen(char color, Pos pos) {
        super(color, 'Q', pos);
    }

    @Override
    void addPossibleMoves() {
        for (int i = 0; i < SIZE; i++) {
            //straight moves
            possibleMoves.add(current.getMove(0, i));
            possibleMoves.add(current.getMove(0, -i));
            possibleMoves.add(current.getMove(i, 0));
            possibleMoves.add(current.getMove(-i, 0));

            //diagonal moves
            possibleMoves.add(current.getMove(i, i));
            possibleMoves.add(current.getMove(i, -i));
            possibleMoves.add(current.getMove(-i, i));
            possibleMoves.add(current.getMove(-i, -i));
        }
    }
    
}
