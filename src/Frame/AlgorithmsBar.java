package Frame;

import javax.swing.*;

public class AlgorithmsBar extends JPanel {

    private final MenuBarCallback cb;

    private JButton selectionSortBtn;
    private JButton bubbleSortBtn;
    private JButton mergeSortBtn;
    private JButton heapSortBtn;
    private JButton quickSortButton;
    private JButton insertionSortButton;
    private JButton shellSortButton;

    public AlgorithmsBar(MenuBarCallback cb) {
        this.cb = cb;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addSelectionSortButton();
        addBubbleSortButton();
        addMergeSortButton();
        addHeapSortButton();
        addQuickSortButton();
        addInsertionSortButton();
        addShellSortButton();

        setVisible(true);
    }

    private void addSelectionSortButton() {
        selectionSortBtn = new JButton("Selection sort");
        selectionSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.SELECTION_SORT);
            disableButton(selectionSortBtn);
        });
        add(selectionSortBtn);
    }

    private void addBubbleSortButton() {
        bubbleSortBtn = new JButton("Bubble sort");
        bubbleSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.BUBBLE_SORT);
            disableButton(bubbleSortBtn);
        });
        add(bubbleSortBtn);
    }

    private void addMergeSortButton() {
        mergeSortBtn = new JButton("Merge sort");
        mergeSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.MERGE_SORT);
            disableButton(mergeSortBtn);
        });
        add(mergeSortBtn);
    }

    private void addHeapSortButton() {
        heapSortBtn = new JButton("Heap sort");
        heapSortBtn.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.HEAP_SORT);
            disableButton(heapSortBtn);
        });
        add(heapSortBtn);
    }

    private void addQuickSortButton() {
        quickSortButton = new JButton("Quick sort");
        quickSortButton.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.QUICK_SORT);
            disableButton(quickSortButton);
        });
        add(quickSortButton);
    }

    private void addInsertionSortButton() {
        insertionSortButton = new JButton("Insertion sort");
        insertionSortButton.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.INSERTION_SORT);
            disableButton(insertionSortButton);
        });
        add(insertionSortButton);
    }

    private void addShellSortButton() {
        shellSortButton = new JButton("Shell sort");
        shellSortButton.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.SHELL_SORT);
            disableButton(shellSortButton);
        });
        add(shellSortButton);
    }

    private void disableButton(JButton button) {
        selectionSortBtn.setEnabled(true);
        bubbleSortBtn.setEnabled(true);
        mergeSortBtn.setEnabled(true);
        heapSortBtn.setEnabled(true);
        quickSortButton.setEnabled(true);
        insertionSortButton.setEnabled(true);
        shellSortButton.setEnabled(true);

        button.setEnabled(false);
    }

}
