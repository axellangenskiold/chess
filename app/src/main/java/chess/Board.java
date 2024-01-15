package chess;

import java.util.Observable;
import chess.pieces.*;

@SuppressWarnings("deprecation")
public class Board extends Observable {
    public static int SIZE = 8;
    public static char[] ROW_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public static int[] COLUMN_NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8};

    //this is ugly
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
            // set up back row for each player
            board[0][i].setPiece(BLACK_START_POS[i]);
            board[7][i].setPiece(WHITE_START_POS[i]);

            // set up pawns for each player
            board[6][i].setPiece(new Pawn('w', new Pos(6, i)));
            board[1][i].setPiece(new Pawn('b', new Pos(1, i)));
        }
    }

    public void move(Pos from, Pos to) {
        Piece pieceToMove = getPiece(from);
        Move potentialMove = new Move(from, to);

        if (!pieceToMove.isEmptySquare() && 
            pieceToMove.isPossibleMove(potentialMove) &&
            !get(to).getPiece().isSameColor(pieceToMove) &&
            (pieceToMove.canJump() || isClearPath(from, to)) &&
            specialCaptureCase(pieceToMove, potentialMove)) {
            
            setPiece(pieceToMove, to);
            setChanged();
            notifyObservers("executed");
        }
    }

    public Piece getPiece(Pos pos) {
        return get(pos).getPiece();
    }

    public void setPiece(Piece piece, Pos pos) {
        Pos oldPos = piece.getPos();
        get(pos).setPiece(piece);
        get(oldPos).setToEmpty();
    }

    public Square get(Pos pos) {
        return board[pos.getRow()][pos.getCol()];
    }

    private boolean isClearPath(Pos from, Pos to) {
        int rowStep = Integer.compare(to.getRow(), from.getRow());
        int colStep = Integer.compare(to.getCol(), from.getCol());
    
        int currentRow = from.getRow() + rowStep;
        int currentCol = from.getCol() + colStep;
    
        while (currentRow != to.getRow() || currentCol != to.getCol()) {
            if (!get(new Pos(currentRow, currentCol)).getPiece().isEmptySquare()) {
                //if "is clear"
                return false;
            }
    
            currentRow += rowStep;
            currentCol += colStep;
        }
        return true;
    }

    private boolean specialCaptureCase(Piece piece, Move move) {
        //pawn can only capture diagonal and walk forward on empty square
        if (piece.type() == Piece.PAWN) {
            return !(move.isDiagonal() && !piece.isOppositeColor(getPiece(move.getTo()))) || 
                    (!move.isDiagonal() && piece.isOppositeColor(getPiece(move.getTo())));
                    //(move.isDoubleOrMore() && ((Pawn) piece).isOnStartingRow());
        }
        return !kingInCheck(piece, move);
    }

    private boolean kingInCheck(Piece piece, Move move) {
        return false;
    }


    //print that makes it look nice in the terminal
    public void printBoard() {
        System.out.println("\n\n");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(ROW_LETTERS[i] + "  ");
            for (Square square : board[i]) {
                System.out.print(" " + square.toString() + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("   ");
        for (int i : COLUMN_NUMBERS) {
            System.out.print(" " + i + " ");
        }
    }
}
