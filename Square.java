import java.awt.*;
public class Square {
    boolean alive;
    int x;
    int y;
    
    int size;
    Square[] neighbours;
    public Square(boolean alive, int x, int y) {
        this.alive = alive;
        this.x = x;
        this.y = y;
        size = 10;
    }
    boolean update(Square[][] squares) {
        int numberOfAliveNeighbours = 0;
        for (int i = 0; i < 3; i++) {
            if (x-1+i >= 0 && x-1+i <= 59 && y-1 >= 0) {
                if (squares[x-1+i][y-1].alive) numberOfAliveNeighbours++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (x-1+i >= 0 && x-1+i <= 59 && y+1 <= 59) {
                if (squares[x-1+i][y+1].alive) numberOfAliveNeighbours++;
            }
        }
        if (x-1 >= 0 && squares[x-1][y].alive) numberOfAliveNeighbours++;
        if (x+1 <= 59 && squares[x+1][y].alive) numberOfAliveNeighbours++;
        
        boolean newState = alive;
        if (numberOfAliveNeighbours < 2 || numberOfAliveNeighbours > 3) newState = false;
        else if (numberOfAliveNeighbours == 3) newState = true;
        /*if (numberOfAliveNeighbours == 3 || numberOfAliveNeighbours == 6 || numberOfAliveNeighbours == 8) newState = true;
        else if (numberOfAliveNeighbours != 2 && numberOfAliveNeighbours != 4 && numberOfAliveNeighbours != 5) newState = false;*/
        return alive != newState;
    }
    void show(Graphics g) {
        if (alive) g.setColor(Color.green);
        else g.setColor(Color.black);
        g.fillRect(x*size, y*size, size, size);
    }
}
