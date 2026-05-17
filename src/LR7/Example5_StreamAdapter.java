package LR7;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example5_StreamAdapter {

    private static final String INPUT_PATH  = "src/LR7/example5/input.txt";
    private static final String OUTPUT_PATH = "src/LR7/example5/output.txt";

    public static void main(String[] args) {
        new File("src/LR7/example5").mkdirs();

        // Создаём входной файл
        try (PrintWriter pw = new PrintWriter(new FileWriter(INPUT_PATH))) {
            pw.println("hello world");
            pw.println("java programming");
            pw.println("stream adapters");
            System.out.println("Входной файл создан: " + INPUT_PATH);
        } catch (IOException e) {
            System.out.println("Ошибка создания входного файла: " + e.getMessage());
            return;
        }

        // Читаем из input.txt, конвертируем в верхний регистр, пишем в output.txt
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(INPUT_PATH), StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(OUTPUT_PATH), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
            System.out.println("Данные скопированы в верхнем регистре: " + OUTPUT_PATH);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
}