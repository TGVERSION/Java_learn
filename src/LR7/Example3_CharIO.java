package LR7;

import java.io.*;

public class Example3_CharIO {

    private static final String FILE_PATH = "src/LR7/example3/example_file.txt";

    public static void main(String[] args) {
        new File("src/LR7/example3").mkdirs();

        String data = "Hello, World!";

        // Запись через символьный поток
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            fw.write(data);
            System.out.println("Данные записаны: " + data);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение через символьный поток
        try (FileReader fr = new FileReader(FILE_PATH)) {
            char[] buffer = new char[1024];
            int charsRead = fr.read(buffer);
            System.out.println("Данные прочитаны: " + new String(buffer, 0, charsRead));
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // Удаление файла
        if (new File(FILE_PATH).delete()) {
            System.out.println("Файл удалён: " + FILE_PATH);
        }
    }
}