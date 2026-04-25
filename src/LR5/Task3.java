package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Привет", "машина", "Карета", "вермишель", "Код");

        System.out.println("Исходный список: " + strings);

        List<String> result = filterCapitalizedStrings(strings);

        System.out.println("Строки с большой буквы: " + result);
    }
}
