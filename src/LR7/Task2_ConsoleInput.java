package LR7;

import java.io.*;
import java.util.Scanner;

public class Task2_ConsoleInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла (без пути): ");
        String fileName = scanner.nextLine().trim();

        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();

        String dirPath  = "src/LR7/task2";
        String filePath = dirPath + "/" + fileName;
        new File(dirPath).mkdirs();

        // Запись через BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(text);
            System.out.println("\nДанные записаны в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
            return;
        }

        // Чтение через BufferedReader
        System.out.println("Содержимое файла:");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}