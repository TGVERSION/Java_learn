package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task8 {

    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 7, 1, 15, 9, 22, 5, 18, 11, 2);
        int threshold = 9;

        System.out.println("Исходный список: " + numbers);
        System.out.println("Пороговое значение: " + threshold);

        List<Integer> result = filterGreaterThan(numbers, threshold);

        System.out.println("Числа больше " + threshold + ": " + result);
    }
}
