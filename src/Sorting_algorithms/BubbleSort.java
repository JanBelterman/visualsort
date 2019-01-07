package Sorting_algorithms;

import Frame.Panel;
import Util.Util;
import Config.Config;

public class BubbleSort {

    private Panel panel;
    private int[] array;

    public BubbleSort(Panel panel) {
        this.panel = panel;
        Config.ELEMENT_WIDTH = 10;
        Config.SLEEP_MILLIS = 1;
        this.array = Util.generateArray(panel.getWidth(), Config.FRAME_HEIGHT, Config.ELEMENT_WIDTH);
    }

    // Run bubble sort algorithm
    public void run() {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    panel.update(array);
                }
    }

}
