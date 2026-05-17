package LR7;

import java.io.*;

public class Example4_BufferedIO {

    private static final String FILE_PATH = "src/LR7/example4/example_file.txt";

    public static void main(String[] args) {
        new File("src/LR7/example4").mkdirs();

        String data = "Строка первая\nСтрока вторая\nСтрока третья";

        // Запись через BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write(data);
            System.out.println("Данные записаны (BufferedWriter)");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение через BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int lineNumber = 1;
            System.out.println("Содержимое файла:");
            while ((line = br.readLine()) != null) {
                System.out.println("  Строка " + lineNumber++ + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // Удаление файла
        if (new File(FILE_PATH).delete()) {
            System.out.println("Файл удалён: " + FILE_PATH);
        }
    }
}