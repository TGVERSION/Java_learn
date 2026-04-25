package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hello World", "Java Programming", "Hello Java", "Python", "World Cup");
        String substring = "Java";

        System.out.println("Исходный список: " + strings);
        System.out.println("Искомая подстрока: " + substring);

        List<String> result = filterBySubstring(strings, substring);

        System.out.println("Строки с подстрокой \"" + substring + "\": " + result);
    }
}
