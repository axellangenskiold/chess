package chess;

public class Color {

    public static char WHITE = 'w';
    public static char BLACK = 'b';
    char color;
    
    public Color(char c) {
        this.color = c;
    }

    public boolean isBlack() {
        return (color == 'b');
    }

    public boolean isWhite() {
        return (color == 'w');
    }

    public boolean isEmpty() {
        return (color == 'e');
    }

    public boolean equals(Color other) {
        return this.color == other.color;
    }
}
