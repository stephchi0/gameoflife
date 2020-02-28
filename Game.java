import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
class Game extends JPanel implements ActionListener, MouseListener, KeyListener{
    boolean start = false;
    Space space = new Space();//, new int[]{6, 7});
    
    ArrayList<int[]> coordinates = new ArrayList<int[]>();
    boolean play = false;
    void setup() {
        setBackground(Color.black);
        new Timer(50, this).start();
        start = true;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!start) setup();
        space.update();
        if (play) space.show(g);
        else {
            g.setColor(Color.green);
            for (int i = 0; i < coordinates.size(); i++) {
                g.fillRect(coordinates.get(i)[0]*10, coordinates.get(i)[1]*10, 10, 10);
            }
        }
        g.setColor(Color.white);
        if (play) g.drawString("PRESS SPACE TO STOP", 50, 50);
        else g.drawString("PRESS SPACE TO START", 50, 50);
    }
    public void mousePressed(MouseEvent e) {
        if (!play) {
            int x = e.getX()/10;
            int y = e.getY()/10;
            int[] inputCoordinate = {x, y};
            
            int index = -1;
            for (int i = 0; i < coordinates.size(); i++) {
                int[] coordinate = coordinates.get(i);
                if (coordinate[0] == inputCoordinate[0] && coordinate[1] == inputCoordinate[1]) {
                    index = i;
                }
            }
            if (index != -1) coordinates.remove(index);
            else coordinates.add(inputCoordinate);
            repaint();
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (play) repaint();
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            play = !play;
            if (play) {
                space = new Space();
                for (int i = 0; i < coordinates.size(); i++) {
                    space.setAlive(coordinates.get(i)[0], coordinates.get(i)[1]);
                }
            }
            repaint();
        }
    }
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}