package LR4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ByteSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            if (n <= 0) throw new IllegalArgumentException("Размер должен быть > 0");
            byte[] arr = new byte[n];
            int sum = 0;
            System.out.println("Введите элементы массива (тип byte от -128 до 127):");
            for (int i = 0; i < n; i++) {
                try {
                    int input = scanner.nextInt();
                    if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                        throw new ArithmeticException("Значение за границами диапазона byte");
                    }
                    arr[i] = (byte) input;
                    sum += arr[i];
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена строка вместо числа. Элемент пропущен.");
                    scanner.next();
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка: " + e.getMessage() + " – элемент пропущен.");
                }
            }
            System.out.println("Сумма элементов: " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: ввод строки вместо числа для размера массива");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
