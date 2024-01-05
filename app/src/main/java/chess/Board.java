package chess;


public class Board {
    public static int SIZE = 8;
    
    Model model;
    Square[][] board;

    public Board(Model model) {
        this.model = model;

        this.board = new Square[SIZE][SIZE];
    }

    public void setUp() {
        for (Square[] row : board) {
            for (Square s : row) {
                s = new Square();
            }
        }
    }
}
