import Config.Config;
import Frame.ControlBar;
import Frame.AlgorithmsBar;
import Frame.Panel;
import Frame.MenuBarCallback;
import Frame.SortingAlgorithmEnum;
import Sorting_algorithms.*;

import javax.swing.*;
import java.awt.*;

public class Manager implements MenuBarCallback {

    private JFrame frame;
    private Panel panel;
    private SortingAlgorithm sortingAlgorithm;

    private Thread sortingThread;

    public void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Visual sorting");
        frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);

        panel = new Panel();

        frame.getContentPane().add(new ControlBar(this), BorderLayout.NORTH);
        frame.getContentPane().add(new AlgorithmsBar(this), BorderLayout.WEST);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        sortingAlgorithm = new SelectionSort(panel);

        panel.addSortingAlgorithm(sortingAlgorithm);

//        frame.repaint();

//        startSortingThread();
    }

    private void stopSortingThread() {
        sortingThread.stop(); // TODO naar interrupt??
    }

    private void startSortingThread() {
        sortingThread = new Thread(() -> {
            sortingAlgorithm.run();
        });
        sortingThread.start();
    }

    private void pauseSortingThread() {
        try {
            sortingThread.suspend(); // TODO: kan start of moet ik resume hierna doen?
        } catch (Exception ignored) {

        }
    }

    @Override
    public void onStart() {
        startSortingThread();
    }

    @Override
    public void onPause() {
        pauseSortingThread();
    }

    @Override
    public void onStop() {
        stopSortingThread();
        sortingAlgorithm.reset();
        panel.update(new int[]{});
        frame.repaint();
    }

    @Override
    public void onRestart() {
        stopSortingThread();
        sortingAlgorithm.reset();
        startSortingThread();
    }

    @Override
    public void onSwitchSortingAlgorithm(SortingAlgorithmEnum sa) {
        stopSortingThread();

        sortingAlgorithm = switch (sa) {
            case SELECTION_SORT -> new SelectionSort(panel);
            case BUBBLE_SORT -> new BubbleSort(panel);
            case MERGE_SORT -> new MergeSort(panel);
            case HEAP_SORT -> new HeapSort(panel);
            case QUICK_SORT -> new QuickSort(panel);
            case INSERTION_SORT -> new InsertionSort(panel);
        };

        panel.update(new int[]{});
        frame.repaint();

//        startSortingThread();
    }
}
