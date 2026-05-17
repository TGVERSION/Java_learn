package LR7;

import java.io.File;
import java.util.Scanner;

public class Task5_FileSize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine().trim();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Файл не найден: " + filePath);
        } else if (!file.isFile()) {
            System.out.println("Указанный путь не является файлом: " + filePath);
        } else {
            long sizeBytes = file.length();
            System.out.printf("Файл  : %s%n", file.getAbsolutePath());
            System.out.printf("Размер: %d байт (%.2f КБ)%n", sizeBytes, sizeBytes / 1024.0);
        }
    }
}