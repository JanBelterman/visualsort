import Config.Algorithm;
import Frame.Panel;
import Sorting_algorithms.SortingAlgorithm;

public class Main {

    private static Panel panel;

    private static Algorithm algorithm = Algorithm.SELECTION_SORT;

    public static void main(String[] args) {
        panel = new Panel();

        SortingAlgorithm sortingAlgorithm;

        switch (algorithm) {
            case SELECTION_SORT:
                sortingAlgorithm = new Sorting_algorithms.SelectionSort(panel);
                break;
            case BUBBLE_SORT:
                sortingAlgorithm = new Sorting_algorithms.BubbleSort(panel);
                break;
            case MERGE_SORT:
                sortingAlgorithm = new Sorting_algorithms.MergeSort(panel);
                break;
            default:
                sortingAlgorithm = new Sorting_algorithms.SelectionSort(panel);
        }

        sortingAlgorithm.run();

    }

}
