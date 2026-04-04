package LR3;

import java.util.Scanner;

public class RecursiveArray {
    private static final Scanner scanner = new Scanner(System.in);

    // Рекурсивный ввод массива
    public static void inputArray(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.print("arr[" + index + "] = ");
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1);
    }

    // Рекурсивный вывод массива
    public static void outputArray(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Ввод элементов массива:");
        inputArray(array, 0);
        System.out.println("Вывод массива:");
        outputArray(array, 0);
        scanner.close();
    }
}
