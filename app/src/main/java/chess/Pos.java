package chess;

public class Pos {

    Object[] pos = {null, null};
    
    public Pos(char row, int col) {
        pos[0] = row;
        pos[1] = col;
    }

    public char getRow() {
        return (char) pos[0];
    }

    public int getCol() {
        return (int) pos[1];
    }
}
