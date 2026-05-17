package LR7;

import java.io.*;
import java.util.Scanner;

public class Task8_ObjectSerialization {

    // Класс, подлежащий сериализации
    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;
        private final int    age;
        private final String group;
        private final double score;

        public Student(String name, int age, String group, double score) {
            this.name  = name;
            this.age   = age;
            this.group = group;
            this.score   = score;
        }

        public void printInfo() {
            System.out.println("Имя:" + name);
            System.out.println("Возраст:" + age);
            System.out.println("Группа:" + group);
            System.out.printf( "score: %.2f%n", score);
        }
    }

    private static final String FILE_PATH = "src/LR7/task8/student.ser";

    public static void main(String[] args) throws IOException {
        new File("src/LR7/task8").mkdirs();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя студента:");
        String name = scanner.nextLine().trim();

        System.out.print("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Введите группу:");
        String group = scanner.nextLine().trim();

        System.out.print("Введите средний балл:");
        double score = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));

        Student student = new Student(name, age, group, score);

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(student);
            System.out.println("\nОбъект сериализован:" + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации:" + e.getMessage());
            return;
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Student restored = (Student) ois.readObject();
            System.out.println("Объект восстановлен из файла:");
            restored.printInfo();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации:" + e.getMessage());
        }
    }
}