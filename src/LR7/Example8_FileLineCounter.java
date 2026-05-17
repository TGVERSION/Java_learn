package LR7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example8_FileLineCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new FileReader("src/LR7/example8_1/input.txt"));

        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();

        System.out.println("Количество строк в файле: " + lineCount);
    }
}
