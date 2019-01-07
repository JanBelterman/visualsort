import java.util.Random;

public class Main {

    private static Frame frame;

    public static void main(String[] args) {

        // Working values
        int width = 1900;
        int height = 800;
        int interval = 1;

        // Create frame
        frame = new Frame(width, height, interval);

        int[] array = generateArray(width, height, interval);

//        selectionSort(array);
        mergeSort(array, 0, array.length - 1);
    }

    // Generate random array
    private static int[] generateArray(int width, int height, int interval) {
        Random random = new Random();
        int[] array = new int[width / interval];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(height - 50);
        }
        return array;
    }

    // Run selection sort algorithm
    private static void selectionSort(int[] array) {
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
            update(array);
        }
    }
    private static void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array , m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }
    private static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            update(arr);
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
            update(arr);
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
            update(arr);
        }
    }

    // Update the frame with the current list
    private static void update(int[] array) {
        // Delay
        try {
            Thread.sleep(4);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        // Update frame
        frame.update(array);
    }

}
