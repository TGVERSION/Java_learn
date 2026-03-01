package Timus;

import java.util.Scanner;
public class Task_1877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a % 2 == 0 || b % 2 == 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}