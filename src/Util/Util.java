package Util;

import java.util.Random;

public class Util {

    // Generate random array
    public static int[] generateArray(int width, int height, int elementWidth) {
        Random random = new Random();
        int[] array = new int[width / elementWidth];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(height - 50);
        }
        return array;
    }

}
