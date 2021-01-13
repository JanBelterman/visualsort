package Sorting_algorithms;

import Config.Config;
import Frame.Panel;
import Generator.ArrayGenerator;

public abstract class SortingAlgorithm {

    protected int[] array;

    protected Panel panel;

    public SortingAlgorithm(Panel panel) {
        this.panel = panel;
        this.array = ArrayGenerator.generateArray(panel.getHeight(), Config.ARRAY_SIZE);
    }

    public abstract void run();

    public int getCount() {
        return array.length;
    }

    public void reset() {
        this.array = ArrayGenerator.generateArray(panel.getHeight(), Config.ARRAY_SIZE);
    }

}
