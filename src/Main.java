import Frame.Panel;
import Sorting_algorithms.*;

public class Main {

    public static void main(String[] args) {
        Panel panel = new Panel();

//        SortingAlgorithm sortingAlgorithm = new SelectionSort(panel);
//        SortingAlgorithm sortingAlgorithm = new BubbleSort(panel);
//        SortingAlgorithm sortingAlgorithm = new MergeSort(panel);
//        SortingAlgorithm sortingAlgorithm = new QuickSort(panel);
        SortingAlgorithm sortingAlgorithm = new HeapSort(panel);

        panel.addSortingAlgorithm(sortingAlgorithm);

        sortingAlgorithm.run();

    }

}
