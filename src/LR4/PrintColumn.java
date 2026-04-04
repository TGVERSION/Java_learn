package LR4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintColumn {
    public static void main(String[] args) {
        // Исходная матрица 3x4
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите номер столбца (от 0 до " + (matrix[0].length - 1) + "): ");
            int col = scanner.nextInt();
            if (col < 0 || col >= matrix[0].length) {
                throw new ArrayIndexOutOfBoundsException("Столбца с таким номером нет");
            }
            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][col]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
