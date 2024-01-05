package chess.pieces;

import chess.Pos;

public class Move {

    Pos from;
    Pos to;
    public Move(Pos from, Pos to) {
        this.from = from;
        this.to = to;
    }
}
