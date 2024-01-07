package chess;

import chess.pieces.Move;

public class Pos {

    private static int SIZE = 8;

    Object[] pos = {null, null};
    
    public Pos(char row, int col) {
        pos[0] = row;
        pos[1] = col;
    }

    public Pos(int row, int col) {
        this((char) (row + 97), col);
    }

    public int getRow() {
        return (int) (((char) pos[0]) - 97); //convert char to number (a returns 0, b returns 1)
    }

    public int getCol() {
        return (int) pos[1]-1;
    }

    public Move getMove(int x, int y) {
        return new Move(this, new Pos(getRow() + x, getCol() + y));
    }

    public boolean isOutOfBounds() {
        return (getRow() < 0 || getRow() >= SIZE || getCol() < 0 || getCol() >= SIZE);
    }

    public boolean equals(Pos other) {
        return (getRow() == other.getRow() && getCol() == other.getCol());
    }

    public String toString() {
        return ((char) pos[0] + String.valueOf(pos[1]));
    }
}
