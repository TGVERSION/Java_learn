package LR7;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example6_PrintWriter {

    private static final String FILE_PATH = "src/LR7/example6/example_file.txt";

    public static void main(String[] args) {
        new File("src/LR7/example6").mkdirs();

        // Запись с помощью PrintWriter
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_PATH), StandardCharsets.UTF_8))) {
            pw.println("Первая строка — PrintWriter");
            pw.println("Вторая строка — быстро и удобно");
            pw.printf("Форматированное число: %.2f%n", 3.14159);
            System.out.println("Данные записаны в файл с помощью PrintWriter");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Вывод PrintWriter напрямую в консоль
        try (PrintWriter consolePw = new PrintWriter(System.out, true, StandardCharsets.UTF_8)) {
            consolePw.println("PrintWriter выводит в консоль быстрее, чем System.out.println");
        }

        // Чтение и вывод содержимого файла
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("Содержимое файла:");
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}