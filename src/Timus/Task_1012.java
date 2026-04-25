package Timus;

import java.math.BigInteger;
import java.util.Scanner;

public class Task_1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        BigInteger K1 = BigInteger.valueOf(k - 1);

        // dp[0] - последняя цифра 0, dp[1] - последняя цифра не 0
        BigInteger dpZero = BigInteger.ZERO;      // первая цифра не может быть 0
        BigInteger dpNonZero = BigInteger.valueOf(k - 1);

        for (int i = 2; i <= n; i++) {
            BigInteger newZero    = dpNonZero;
            BigInteger newNonZero = K1.multiply(dpZero.add(dpNonZero));
            dpZero    = newZero;
            dpNonZero = newNonZero;
        }

        System.out.println(dpZero.add(dpNonZero));
    }
}
