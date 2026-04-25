package Timus;

import java.util.Scanner;

public class Task_1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] f = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            f[i] = scanner.nextLong();
        }

        long maxSlope = -1;
        int ansA = 1, ansB = 2;

        for (int i = 1; i < n; i++) {
            long slope = Math.abs(f[i + 1] - f[i]);
            if (slope > maxSlope) {
                maxSlope = slope;
                ansA = i;
                ansB = i + 1;
            }
        }

        System.out.println(ansA + " " + ansB);
    }
}

