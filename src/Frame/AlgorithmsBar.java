package Frame;

import javax.swing.*;

public class AlgorithmsBar extends JPanel {

    private final MenuBarCallback cb;

    private JButton selectionSortBtn;
    private JButton bubbleSortBtn;
    private JButton mergeSortBtn;
    private JButton heapSortBtn;
    private JButton quickSortBtn;

    public AlgorithmsBar(MenuBarCallback cb) {
        this.cb = cb;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addSelectionSortButton();
        addBubbleSortButton();
        addMergeSortButton();
        addHeapSortButton();
        addQuickSortButton();

        setVisible(true);
    }

    public void addSelectionSortButton() {
        selectionSortBtn = new JButton("SelectionSort");
        selectionSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.SELECTION_SORT);
            disableButton(selectionSortBtn);
        });
        add(selectionSortBtn);
        selectionSortBtn.setEnabled(false);
    }

    public void addBubbleSortButton() {
        bubbleSortBtn = new JButton("BubbleSort");
        bubbleSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.BUBBLE_SORT);
            disableButton(bubbleSortBtn);
        });
        add(bubbleSortBtn);
    }

    public void addMergeSortButton() {
        mergeSortBtn = new JButton("MergeSort");
        mergeSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.MERGE_SORT);
            disableButton(mergeSortBtn);
        });
        add(mergeSortBtn);
    }

    public void addHeapSortButton() {
        heapSortBtn = new JButton("HeapSort");
        heapSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.HEAP_SORT);
            disableButton(heapSortBtn);
        });
        add(heapSortBtn);
    }

    public void addQuickSortButton() {
        quickSortBtn = new JButton("QuickSort");
        quickSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.QUICK_SORT);
            disableButton(quickSortBtn);
        });
        add(quickSortBtn);
    }

    private void disableButton(JButton button) {
        selectionSortBtn.setEnabled(true);
        bubbleSortBtn.setEnabled(true);
        mergeSortBtn.setEnabled(true);
        heapSortBtn.setEnabled(true);
        quickSortBtn.setEnabled(true);

        button.setEnabled(false);
    }

}
