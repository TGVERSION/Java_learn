package LR7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example8_FileCopier {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/LR7/example8_1/input.txt");
        FileWriter writer = new FileWriter("src/LR7/example8_1/output.txt");

        int c;
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }

        reader.close();
        writer.close();

        System.out.println("Файл скопирован успешно!");
    }
}