package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Serial;

import Config.Config;
import Sorting_algorithms.SortingAlgorithm;

public class Panel extends JPanel {

    @Serial
    private static final long serialVersionUID = 4236119898795955335L;

    private int elementWidth;

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

    public void addSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        elementWidth = calculateElementWidth(sortingAlgorithm.getCount(), Config.FRAME_WIDTH);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int count = sortingAlgorithm.getCount();
                int width = e.getComponent().getWidth();
                elementWidth = calculateElementWidth(count, width);
            }
        });
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
            g.fillRect(i * elementWidth, this.getHeight() - array[i], elementWidth, array[i]);
    }

    private int calculateElementWidth(int count, int width) {
        return width / count;
    }

}
