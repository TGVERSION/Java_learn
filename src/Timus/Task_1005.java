package Timus;

import java.util.Scanner;

public class Task_1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] w = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            total += w[i];
        }

        int minDiff = Integer.MAX_VALUE;

        // Перебираем все подмножества
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += w[i];
                }
            }
            int diff = Math.abs(total - 2 * sum);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        System.out.println(minDiff);
    }
}
