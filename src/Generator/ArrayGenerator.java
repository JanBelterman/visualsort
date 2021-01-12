package Generator;

import java.util.Random;

public class ArrayGenerator {

    // Generate random array
    public static int[] generateArray(int height, int count) {
        Random random = new Random();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(height);
        }
        return array;
    }

}
