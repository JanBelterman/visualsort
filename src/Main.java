import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Working values
        int width = 1900;
        int height = 800;
        int interval = 20;

        // Create frame
        Frame frame = new Frame(width, height, interval);

        Random random = new Random();
        // Generate random array
        int[] array = new int[width / interval];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(height - 50);
        }

        // Sorting
        for (int i = 0; i < array.length; i++) {

            // Check smallest
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j; // New smallest found
                }
            }

            // Swap
            swap(array, min_idx, i);

            // Delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            // Update frame
            frame.update(array);

        }

    }

    private static void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

}
