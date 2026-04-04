package LR3;

import java.util.*;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        int N = 100000; // количество человек

        // Моделирование с ArrayList
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= N; i++) arrayList.add(i);
        long startAL = System.nanoTime();
        int resultAL = simulate(arrayList);
        long endAL = System.nanoTime();
        System.out.println("ArrayList: " + (endAL - startAL) / 1_000_000 + " ms, остался: " + resultAL);

        // Моделирование с LinkedList
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= N; i++) linkedList.add(i);
        long startLL = System.nanoTime();
        int resultLL = simulate(linkedList);
        long endLL = System.nanoTime();
        System.out.println("LinkedList: " + (endLL - startLL) / 1_000_000 + " ms, остался: " + resultLL);
    }

    // Общий метод моделирования: вычёркиваем каждого второго
    private static int simulate(List<Integer> list) {
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.getFirst();
    }
}
