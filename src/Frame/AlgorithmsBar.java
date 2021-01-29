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
        quickSortButton = new JButton("QuickSort");
        quickSortButton.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.QUICK_SORT);
            disableButton(quickSortButton);
        });
        add(quickSortButton);
    }

    public void addInsertionSortButton() {
        insertionSortButton = new JButton("InsertionSort");
        insertionSortButton.addActionListener(e -> {
            cb.onSwitchSortingAlgorithm(SortingAlgorithmEnum.INSERTION_SORT);
            disableButton(insertionSortButton);
        });
        add(insertionSortButton);
    }

    public void addShellSortButton() {
        shellSortButton = new JButton("ShellSort");
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
