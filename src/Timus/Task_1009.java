package Timus;

import java.util.Scanner;

public class Task_1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long z  = 0;
        long nz = k - 1;

        for (int i = 2; i <= n; i++) {
            long newZ  = nz;
            long newNz = (long)(k - 1) * (z + nz);
            z  = newZ;
            nz = newNz;
        }

        System.out.println(z + nz);
    }
}
