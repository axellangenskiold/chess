package chess;


import chess.pieces.*;

public class Board {
    public static int SIZE = 8;
    public static char[] ROW_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public static int[] COLUMN_NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8};

    public static Piece[] WHITE_START_POS = {
        new Rook('w', new Pos(0,0)), 
        new Knight('w', new Pos(0,1)), 
        new Bishop('w', new Pos(0,2)), 
        new King('w', new Pos(0,3)), 
        new Queen('w', new Pos(0,4)), 
        new Bishop('w', new Pos(0,5)), 
        new Knight('w', new Pos(0,6)), 
        new Rook('w', new Pos(0,7))};

    public static Piece[] BLACK_START_POS = {
        new Rook('b', new Pos(0,0)), 
        new Knight('b', new Pos(0,1)), 
        new Bishop('b', new Pos(0,2)), 
        new King('b', new Pos(0,3)), 
        new Queen('b', new Pos(0,4)), 
        new Bishop('b', new Pos(0,5)), 
        new Knight('b', new Pos(0,6)), 
        new Rook('b', new Pos(0,7))};
    
    Square[][] board;

    public Board() {
        this.board = new Square[SIZE][SIZE];
        setUp();
    }

    public void setUp() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Square(new Pos(ROW_LETTERS[i], COLUMN_NUMBERS[j]));
            }
        }

        for (int i = 0; i < SIZE; i++) {
            board[1][i].setPiece(new Pawn('b', new Pos(1, i)));
        }
        for (int i = 0; i < SIZE; i++) {
            board[6][i].setPiece(new Pawn('w', new Pos(6, i)));
        }
        for (int i = 0; i < SIZE; i++) {
            board[0][i].setPiece(BLACK_START_POS[i]);
            board[7][i].setPiece(WHITE_START_POS[i]);
        }
    }

    public void move(Pos from, Pos to) {
        Piece toMove = getPiece(from);

        if (!toMove.isEmptySquare()) {
            setPiece(toMove, to);
            remove(from);
        }
    }

    public Piece getPiece(Pos pos) {
        return get(pos).getPiece();
    }

    public void setPiece(Piece piece, Pos pos) {
        get(pos).setPiece(piece);
    }

    public void remove(Pos pos) {
        get(pos).setToEmpty();
    }

    public Square get(Pos pos) {
        return board[pos.getRow()][pos.getCol()];
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(ROW_LETTERS[i] + " ");
            for (Square square : board[i]) {
                System.out.print(" " + square.toString() + " ");
            }
            System.out.println();
        }

        System.out.print("  ");
        for (char c : ROW_LETTERS) {
            System.out.print(" " + c + " ");
        }
    }
}
