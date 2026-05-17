package LR7;

import java.io.*;

public class Example7_Serialization {

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;
        private final int    age;
        private final String email;

        public Person(String name, int age, String email) {
            this.name  = name;
            this.age   = age;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person { name='" + name + "', age=" + age + ", email='" + email + "' }";
        }
    }

    private static final String FILE_PATH = "src/LR7/example7/person.ser";

    public static void main(String[] args) {
        new File("src/LR7/example7").mkdirs();

        Person person = new Person("Иван", 23, "ivan@mail.ru");

        // Сериализация (запись в файл)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(person);
            System.out.println("Объект сериализован: " + person);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
            return;
        }

        // Десериализация (восстановление из файла)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Объект восстановлен: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }
    }
}
