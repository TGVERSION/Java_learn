package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task6 {

    public static List<Integer> filterDivisible(List<Integer> list, int divisor) {
        return list.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 18, 20);
        int divisor = 3;

        System.out.println("Исходный список: " + numbers);
        System.out.println("Делитель: " + divisor);

        List<Integer> result = filterDivisible(numbers, divisor);

        System.out.println("Числа, делящиеся на " + divisor + ": " + result);
    }
}
