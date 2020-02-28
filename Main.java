import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setSize(600, 600);
        Game pane = new Game();
        frame.setContentPane(pane);
        pane.setLayout(null);
        
        
        frame.addKeyListener(pane);
        pane.addMouseListener(pane);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
