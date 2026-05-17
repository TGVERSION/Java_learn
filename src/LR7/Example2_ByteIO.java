package LR7;

import java.io.*;

public class Example2_ByteIO {

    private static final String FILE_PATH = "src/LR7/example2/example_file.txt";

    public static void main(String[] args) {
        new File("src/LR7/example2").mkdirs();

        String data = "Hello, World!";

        // Запись через байтовый поток
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            fos.write(data.getBytes());
            System.out.println("Данные записаны: " + data);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение через байтовый поток
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            byte[] buffer = fis.readAllBytes();
            System.out.println("Данные прочитаны: " + new String(buffer));
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // Удаление файла
        if (new File(FILE_PATH).delete()) {
            System.out.println("Файл удалён: " + FILE_PATH);
        }
    }
}