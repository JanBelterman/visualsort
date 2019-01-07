import Frame.Panel;

public class Main {

    private static Panel panel;

    public static void main(String[] args) {
        panel = new Panel();

        Sorting_algorithms.SelectionSort selectionSort = new Sorting_algorithms.SelectionSort(panel);
        selectionSort.run();

//        Sorting_algorithms.BubbleSort bubbleSort = new Sorting_algorithms.BubbleSort(panel);
//        bubbleSort.run();

//        MergeSort mergeSort = new MergeSort(panel);
//        mergeSort.run();

    }

}
