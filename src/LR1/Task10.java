package LR1;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();
        int sum = a + b;
        int diff = a - b;
        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + diff);
        scanner.close();
    }
}