package LR5;

import java.util.Arrays;

public class Task1 {

    public static int[] filterEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Исходный массив: " + Arrays.toString(array));

        int[] result = filterEvenNumbers(array);

        System.out.println("Только чётные числа: " + Arrays.toString(result));
    }
}
