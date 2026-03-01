package LR2;

public class Task2 {
    public static void main(String[] args) {
        int n = 5; // размер массива
        int[][] matrix = new int[n][n];

        int value = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (value <= n * n) {
            // Верхняя строка слева направо
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            // Правый столбец сверху вниз
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            // Нижняя строка справа налево (если ещё остались строки)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--;
            }

            // Левый столбец снизу вверх
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }

        // Вывод массива
        System.out.println("Массив, заполненный спиралью:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}