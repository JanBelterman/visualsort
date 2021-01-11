package Frame;

import javax.swing.*;
import java.awt.*;

import Config.Config;

public class Panel extends JPanel {

    private static final long serialVersionUID = 4236119898795955335L;

    private JFrame frame;
    private int[] array;

    public Panel() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Visual sorting");
        frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    // Update array & repaint
    public void update(int[] array) {
        // Delay
        try {
            Thread.sleep(Config.SLEEP_MILLIS, 1);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        this.array = array;
        frame.repaint();
    }

    // draw a rectangle for every element in the array
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < array.length; i++)
            g.fillRect(i * Config.ELEMENT_WIDTH, this.getHeight() - array[i], Config.ELEMENT_WIDTH, array[i]);
    }

}
