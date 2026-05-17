package LR7;

import java.io.*;
import java.util.Scanner;

public class Task6_SearchWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу:");
        String filePath = scanner.nextLine().trim();

        System.out.print("Введите слово для поиска:");
        String searchWord = scanner.nextLine().trim();

        int matchCount  = 0;
        int lineNumber  = 0;

        System.out.println("\nСтроки, содержащие \"" + searchWord + "\":");
        System.out.println("─".repeat(50));

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchWord)) {
                    System.out.printf("Строка %4d: %s%n", lineNumber, line);
                    matchCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден:" + filePath);
            return;
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        System.out.println("─".repeat(50));
        if (matchCount == 0) {
            System.out.println("Слово не найдено.");
        } else {
            System.out.println("Найдено строк:" + matchCount + "из" + lineNumber);
        }
    }
}