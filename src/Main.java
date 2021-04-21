import javax.swing.*;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        panel.unicornImage();
        frame.add(panel);
        frame.setSize(1920, 1050);
        frame.setVisible(true);

         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         while (true){
         frame.repaint();

        }
    }
}