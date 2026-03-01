package LR1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите год рождения: ");
        int birthYear = scanner.nextInt();
        int currentYear = 2026;
        int age = currentYear - birthYear;
        System.out.println(name + ", ваш возраст: " + age);
        scanner.close();
    }
}