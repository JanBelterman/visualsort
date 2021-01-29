import Config.Config;
import Frame.ControlBar;
import Frame.AlgorithmsBar;
import Frame.Panel;
import Frame.MenuBarCallback;
import Frame.SortingAlgorithmEnum;
import SortingAlgorithms.*;

import javax.swing.*;
import java.awt.*;

public class Manager implements MenuBarCallback {

    private JFrame frame;
    private Panel panel;
    private ControlBar controlBar;
    private SortingAlgorithm sortingAlgorithm;

    private Thread sortingThread;

    // TODO: when state == paused (enum), change start button text to resume. State machine or something nice. (STATE.RUNNING (start disabled),IDLE(stop & pause disabled),PAUSED(pause disabled, start should display resume)
    // TODO: fix slow after some runtime & make sure always one thread active and properly disposed of so not accidentally starting multiple threads (probably also need to make sure algorithms perform about the same amount of paints otherwise some will cause lag or just seem slower, do this by using less elements or smart drawing

    public void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Visual sorting");
        frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);

        panel = new Panel();
        controlBar = new ControlBar(this);
        controlBar.disableAll();

        frame.getContentPane().add(controlBar, BorderLayout.NORTH);
        frame.getContentPane().add(new AlgorithmsBar(this), BorderLayout.WEST);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.repaint();
    }

    private void stopSortingThread() {
        if (sortingThread != null) {
            sortingThread.stop(); // TODO naar interrupt??
        }
    }

    private void startSortingThread() {
        sortingThread = new Thread(() -> {
            sortingAlgorithm.run();
        });
        sortingThread.start();
    }

    private void pauseSortingThread() {
        try {
            sortingThread.suspend(); // TODO: kan start of moet ik resume hierna doen? & hoe houdt ie state bij van de array??? tuurlijk als ik continue gaat gwn die thread verder, duhh
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
            case SHELL_SORT -> new ShellSort(panel);
        };

        panel.addSortingAlgorithm(sortingAlgorithm);

        controlBar.enableAll();

        panel.update(new int[]{});
        frame.repaint();
    }
}
