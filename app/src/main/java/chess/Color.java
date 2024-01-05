package chess;

public class Color {

    char color;
    
    public Color(char c) {
        this.color = c;
    }

    public boolean isBlack() {
        if (color == 'b') {
            return true;
        }
        return false;
    }

    public boolean isWhite() {
        if (color == 'w') {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (color == 'e') {
            return true;
        }
        return false;
    }
}
