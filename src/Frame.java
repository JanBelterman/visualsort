import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel implements Runnable {

    private JFrame frame;
    private int[] array;
    private int interval;

    public Frame(int width, int height, int interval) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Visual sorting");
        frame.setSize(width, height);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        this.interval = interval;
    }

    public void update(int[] array) {
        this.array = array;
//        repaint();
        frame.repaint();
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < array.length; i++) {
            g.fillRect(i * interval, 0, interval, array[i]);
        }
    }

    @Override
    public void run() {

    }

}
