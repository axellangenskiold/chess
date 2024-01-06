package chess;

import chess.pieces.Move;

public class Pos {

    Object[] pos = {null, null};
    
    public Pos(char row, int col) {
        pos[0] = row;
        pos[1] = col;
    }

    public Pos(int row, int col) {
        this((char) (row + 97), col);
    }

    public int getRow() {
        return (int) pos[0] - 97; //convert char to number (a returns 0, b returns 2)
    }

    public int getCol() {
        return (int) pos[1];
    }

    public static Move getMove(Pos pos, int x, int y) {
        
        return new Move(pos, new Pos(pos.getRow() - x, pos.getCol() - y));
    }
}
