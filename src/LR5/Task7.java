package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task7 {

    public static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Кот", "Собака", "Попугай", "Рыба", "Черепаха", "Ёж");
        int minLength = 4;

        System.out.println("Исходный список: " + strings);
        System.out.println("Минимальная длина: " + minLength);

        List<String> result = filterByLength(strings, minLength);

        System.out.println("Строки длиннее " + minLength + ": " + result);
    }
}
