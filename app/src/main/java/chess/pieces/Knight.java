package chess.pieces;

import chess.Pos;

public class Knight extends Piece {

    public Knight(char color, Pos pos) {
        super(color, 'n', pos);
        canJump = true;
    }

    @Override
    void addPossibleMoves() {
        //moves "right"
        possibleMoves.add(current.getMove(1, 2));
        possibleMoves.add(current.getMove(-1, 2));

        //moves "up"
        possibleMoves.add(current.getMove(2, -1));
        possibleMoves.add(current.getMove(2, 1));

        //moves "left"
        possibleMoves.add(current.getMove(-1, -2));
        possibleMoves.add(current.getMove(1, -2));

        //moves "down"
        possibleMoves.add(current.getMove(-2, -1));
        possibleMoves.add(current.getMove(-2, 1));
    }
    
}
