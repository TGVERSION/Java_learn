package LR5;

import java.util.Arrays;

public class Task2 {

    public static int[] findCommonElements(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .filter(n -> Arrays.stream(array2).anyMatch(m -> m == n))
                .toArray();
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};

        System.out.println("Массив 1: " + Arrays.toString(array1));
        System.out.println("Массив 2: " + Arrays.toString(array2));

        int[] result = findCommonElements(array1, array2);

        System.out.println("Общие элементы: " + Arrays.toString(result));
    }
}
