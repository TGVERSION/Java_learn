package LR7;

import java.io.File;
import java.io.IOException;

public class Example1_FileClass {

    public static void main(String[] args) {
        // Создаём папку
        File folder = new File("src/LR7/example1/example_folder");

        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getPath());
            } else {
                System.out.println("Не удалось создать папку");
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getPath());
        }

        // Создаём файл внутри папки
        File file = new File(folder, "example_file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getPath());
            } else {
                System.out.println("Файл уже существует: " + file.getPath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }

        // Удаляем файл
        if (file.delete()) {
            System.out.println("Файл удалён: " + file.getPath());
        } else {
            System.out.println("Не удалось удалить файл");
        }

        // Удаляем папку
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getPath());
        } else {
            System.out.println("Не удалось удалить папку");
        }
    }
}