package Sorting_algorithms;

import Frame.Panel;
import Util.Util;
import Config.Config;

public class MergeSort implements SortingAlgorithm {

    private Panel panel;
    private int[] array;

    public MergeSort(Panel panel) {
        this.panel = panel;
        Config.ELEMENT_WIDTH = 2;
        Config.SLEEP_MILLIS = 1;
        this.array = Util.generateArray(panel.getWidth(), Config.FRAME_HEIGHT, Config.ELEMENT_WIDTH);
    }

    public void run() {
        mergeSort(array, 0, array.length - 1);
    }

    // Run merge sort algorithm
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array , middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }
    private void merge(int arr[], int left, int middle, int right) {
        // Find sizes of two sub-arrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temp arrays
        int[] leftArray = new int [n1];
        int[] rightArray = new int [n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            panel.update(arr);
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
            panel.update(arr);
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
            panel.update(arr);
        }
    }

}
