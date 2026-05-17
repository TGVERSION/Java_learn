package LR7;

import java.io.*;
import java.util.Scanner;

public class Task7_WriteText {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название файла:");
        String filePath = scanner.nextLine().trim();

        System.out.print("Введите текст для записи:");
        String text = scanner.nextLine();

        // Создаём директории при необходимости
        File file = new File(filePath);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(text);
            System.out.println("\nТекст успешно записан в файл:" + filePath);
            System.out.println(" Количество записанных символов:" + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка записи:" + e.getMessage());
        }
    }
}