package LR4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AveragePositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            if (n <= 0) throw new IllegalArgumentException("Размер должен быть > 0");
            int[] arr = new int[n];
            int sum = 0, count = 0;
            System.out.println("Введите элементы массива (целые числа):");
            for (int i = 0; i < n; i++) {
                try {
                    arr[i] = scanner.nextInt();
                    if (arr[i] > 0) {
                        sum += arr[i];
                        count++;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена не строка, а не число. Элемент пропущен.");
                    scanner.next(); // очистка буфера
                }
            }
            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют");
            }
            double average = (double) sum / count;
            System.out.println("Среднее положительных: " + average);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: ввод строки вместо числа для размера массива");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
