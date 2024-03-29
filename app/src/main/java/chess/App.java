/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package chess;

import chess.gui.GUI;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller(new Board());
        GUI gui = new GUI(controller);
        // controller.printBoard();
        // controller.move(new Pos(1,0), new Pos(3,0)); //move pawn b1
        // controller.move(new Pos(1, 7), new Pos(2, 7)); //move pawn b8
        // controller.move(new Pos(0, 0), new Pos(1,0)); //move rook a1

        // controller.move(new Pos(1, 3), new Pos(3, 3)); //move pawn b4
        // controller.move(new Pos(0, 4), new Pos(4,0)); //move black queen
        // controller.move(new Pos(0, 2), new Pos(4, 6)); //move bishop a3

        // controller.move(new Pos(0, 1), new Pos(2, 2)); //move knight 

        controller.printBoard();
        gui.readFromBoardStart();
    }
}
