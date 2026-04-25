package LR5;

import java.util.List;
import java.util.stream.Collectors;

public class Task4 {

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Исходный список: " + numbers);

        List<Integer> result = squareList(numbers);

        System.out.println("Квадраты чисел: " + result);
    }
}
