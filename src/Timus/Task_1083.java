package Timus;

import java.util.Scanner;

public class Task_1083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String bangs = sc.next();
        int k = bangs.length();

        long result = 1;
        for (int i = n; i > 0; i -= k) {
            result *= i;
        }

        System.out.println(result);
    }
}
