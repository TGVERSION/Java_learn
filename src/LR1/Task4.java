package LR1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите месяц: ");
        String month = scanner.nextLine();
        System.out.print("Введите количество дней в этом месяце: ");
        int days = scanner.nextInt();
        System.out.println("Месяц " + month + " содержит " + days + " дней");
        scanner.close();
    }
}