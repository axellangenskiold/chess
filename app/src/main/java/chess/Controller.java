package chess;

import chess.gui.GUI;
import chess.pieces.Piece;

public class Controller {

    Board board;
    GUI gui;
    
    public Controller(Board board) {
        this.board = board;
    }

    public void move(Pos from, Pos to) {
        board.move(from, to);
    }

    public Piece getPiece(int row, int col) {
        return board.getPiece(new Pos(row, col));
    }

    public void printBoard() {
        board.printBoard();
    }

    public Board getBoard() {
        return board;
    }
}
