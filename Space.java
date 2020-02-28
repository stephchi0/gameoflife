import java.awt.*;
import java.util.*;
public class Space {
    Square[][] squares;
    public Space(int[]... coordinates) {
        squares = new Square[60][60];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                boolean state = false;
                for (int k = 0; k < coordinates.length; k++) {
                    if (coordinates[k][0] == i && coordinates[k][1] == j) {
                        state = true;
                        break;
                    }
                }
                squares[i][j] = new Square(state, i, j);
            }
        }
    }
    void setAlive(int x, int y) {
        squares[x][y].alive = true;
    }
    void update() {
        ArrayList<Square> squaresToChange = new ArrayList<Square>();
        for (Square[] row : squares) {
            for (Square square : row) {
                if (square.update(squares)) squaresToChange.add(square);
            }
        }
        for (Square square : squaresToChange) {
            square.alive = !square.alive;
        }
    }
    void show(Graphics g) {
        for (Square[] row : squares) {
            for (Square square : row) {
                square.show(g);
            }
        }
    }
}
