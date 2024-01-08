package chess;

import chess.gui.GUI;

public class Controller {

    Board board;
    GUI gui;
    
    public Controller(Board model) {
        this.board = new Board();
    }

    public void move(Pos from, Pos to) {
        board.move(from, to);
    }

    public void printBoard() {
        board.printBoard();
    }
}
