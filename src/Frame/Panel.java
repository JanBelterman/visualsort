package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Serial;

import Config.Config;
import SortingAlgorithms.SortingAlgorithm;

public class Panel extends JPanel {

    @Serial
    private static final long serialVersionUID = 4236119898795955335L;

    private int elementWidth;

    private int[] array;

    private SortingAlgorithm sortingAlgorithm;

    public Panel () {
        super();

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (sortingAlgorithm != null) {
                    int count = sortingAlgorithm.getCount();
                    int width = e.getComponent().getWidth();
                    elementWidth = calculateElementWidth(count, width);
                }
            }
        });
    }

    public void addSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        // TODO: change to the width of the panel itself
        this.sortingAlgorithm = sortingAlgorithm;
        elementWidth = calculateElementWidth(sortingAlgorithm.getCount(), Config.FRAME_WIDTH);
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
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.repaint();
    }

    // draw a rectangle for every element in the array
    @Override
    public void paint(Graphics g) {
        if (this.array != null && this.array.length > 0) {
            for (int i = 0; i < array.length; i++)
                g.fillRect(i * elementWidth, this.getHeight() - array[i], elementWidth, array[i]);
        } else if (sortingAlgorithm != null) {
            g.drawString("Press start to run the algorithm", getWidth() / 2 - 100, getHeight() / 2);
        } else {
            g.drawString("Select a sorting algorithm on the left to start.", getWidth() / 2 - 150, getHeight() / 2);
        }
    }

    private int calculateElementWidth(int count, int width) {
        return width / count;
    }

}
