package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task9 {

    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-ЯёЁ]+"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Привет", "Hello123", "Мир", "Java!", "Код", "2024год", "Программа");

        System.out.println("Исходный список: " + strings);

        List<String> result = filterOnlyLetters(strings);

        System.out.println("Строки только из букв: " + result);
    }
}
