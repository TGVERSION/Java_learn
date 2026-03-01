package LR2;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = 10;
        int[] arr = new int[size];

        // Заполнение массива случайными числами
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100); // числа от 0 до 99
        }

        System.out.println("Массив: " + Arrays.toString(arr));

        // Поиск минимального значения
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Сбор индексов минимума
        System.out.print("Минимальное значение: " + min + ", индексы: ");
        for (int i = 0; i < size; i++) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}