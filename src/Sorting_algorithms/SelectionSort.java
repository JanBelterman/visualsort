package Sorting_algorithms;

import Frame.Panel;

public class SelectionSort extends SortingAlgorithm {

    public SelectionSort(Panel panel) {
        super(panel);
    }

    // Run selection sort algorithm
    public void run() {
        // Sorting
        for (int i = 0; i < array.length; i++) {
            // Check smallest
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j; // New smallest found
                }
            }
            swap(array, min_idx, i);
            panel.update(array);
        }
    }
    private void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

}
