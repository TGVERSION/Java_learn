import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int x = scanner.nextInt();
        int a = x - 1;
        int b = x;
        int c = x + 1;
        int sum = a + b + c;
        int square = sum * sum;
        System.out.println(a + ", " + b + ", " + c + ", " + square);
        scanner.close();
    }
}