package LR3;

import java.util.*;

public class CompareCollections {
    private static final int N = 8_000_000; // 8 млн элементов

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        SortedSet<Integer> treeSet = new TreeSet<>();

        // Заполнение
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }

        System.out.println("Сравнение времени операций (N = " + N + ")\n");

        // 1. Добавление в начало
        System.out.println("1. Добавление в начало:");
        measureAddFirst(arrayList, "ArrayList");
        System.out.println("   HashSet и TreeSet не поддерживают добавление в начало.\n");

        // 2. Добавление в конец
        System.out.println("2. Добавление в конец:");
        measureAddLast(arrayList, "ArrayList");
        measureAddLast(hashSet, "HashSet");
        measureAddLast(treeSet, "TreeSet");
        System.out.println();

        // 3. Добавление в середину
        System.out.println("3. Добавление в середину:");
        measureAddMiddle(arrayList, "ArrayList");
        System.out.println("   HashSet и TreeSet не поддерживают добавление в середину.\n");

        // 4. Удаление с начала
        System.out.println("4. Удаление с начала:");
        measureRemoveFirst(arrayList, "ArrayList");
        measureRemoveFirstFromSet(hashSet, "HashSet");
        measureRemoveFirstFromSortedSet(treeSet, "TreeSet");
        System.out.println();

        // 5. Удаление с конца
        System.out.println("5. Удаление с конца:");
        measureRemoveLast(arrayList, "ArrayList");
        measureRemoveLastFromSet(hashSet, "HashSet");
        measureRemoveLastFromSortedSet(treeSet, "TreeSet");
        System.out.println();

        // 6. Удаление из середины
        System.out.println("6. Удаление из середины:");
        measureRemoveMiddle(arrayList, "ArrayList");
        int mid = N / 2;
        measureRemoveByValue(hashSet, "HashSet", mid);
        measureRemoveByValue(treeSet, "TreeSet", mid);
        System.out.println();

        // 7. Получение элемента
        System.out.println("7. Получение элемента:");
        int index = N / 2;
        measureGetByIndex(arrayList, "ArrayList", index);
        measureContains(hashSet, "HashSet", index);
        measureContains(treeSet, "TreeSet", index);
    }

    // ArrayList
    private static void measureAddFirst(List<Integer> list, String name) {
        List<Integer> copy = new ArrayList<>(list);
        long start = System.nanoTime();
        copy.add(0, -1);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms%n", name, (end - start) / 1_000_000);
    }

    private static void measureAddLast(Collection<Integer> col, String name) {
        long start = System.nanoTime();
        col.add(-1);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms%n", name, (end - start) / 1_000_000);
    }

    private static void measureAddMiddle(List<Integer> list, String name) {
        List<Integer> copy = new ArrayList<>(list);
        int mid = copy.size() / 2;
        long start = System.nanoTime();
        copy.add(mid, -1);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms%n", name, (end - start) / 1_000_000);
    }

    private static void measureRemoveFirst(List<Integer> list, String name) {
        List<Integer> copy = new ArrayList<>(list);
        long start = System.nanoTime();
        copy.remove(0);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms%n", name, (end - start) / 1_000_000);
    }

    private static void measureRemoveLast(List<Integer> list, String name) {
        List<Integer> copy = new ArrayList<>(list);
        long start = System.nanoTime();
        copy.remove(copy.size() - 1);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms%n", name, (end - start) / 1_000_000);
    }

    private static void measureRemoveMiddle(List<Integer> list, String name) {
        List<Integer> copy = new ArrayList<>(list);
        int mid = copy.size() / 2;
        long start = System.nanoTime();
        copy.remove(mid);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms%n", name, (end - start) / 1_000_000);
    }

    private static void measureGetByIndex(List<Integer> list, String name, int index) {
        long start = System.nanoTime();
        int val = list.get(index);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms (значение %d)%n", name, (end - start) / 1_000_000, val);
    }

    // HashSet
    private static void measureRemoveFirstFromSet(Set<Integer> set, String name) {
        Set<Integer> copy = new HashSet<>(set);
        int first = copy.iterator().next();
        long start = System.nanoTime();
        copy.remove(first);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms (удалён %d)%n", name, (end - start) / 1_000_000, first);
    }

    private static void measureRemoveLastFromSet(Set<Integer> set, String name) {
        // Для HashSet понятие "последний" отсутствует, удаляем произвольный
        measureRemoveFirstFromSet(set, name);
    }

    // TreeSet
    private static void measureRemoveFirstFromSortedSet(SortedSet<Integer> set, String name) {
        SortedSet<Integer> copy = new TreeSet<>(set);
        int first = copy.first();
        long start = System.nanoTime();
        copy.remove(first);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms (удалён %d)%n", name, (end - start) / 1_000_000, first);
    }

    private static void measureRemoveLastFromSortedSet(SortedSet<Integer> set, String name) {
        SortedSet<Integer> copy = new TreeSet<>(set);
        int last = copy.last();
        long start = System.nanoTime();
        copy.remove(last);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms (удалён %d)%n", name, (end - start) / 1_000_000, last);
    }

    // Удаление по значению (общее для Set)
    private static void measureRemoveByValue(Collection<Integer> col, String name, int value) {
        long start = System.nanoTime();
        col.remove(value);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms (удаление значения %d)%n", name, (end - start) / 1_000_000, value);
    }

    // contains для Set
    private static void measureContains(Set<Integer> set, String name, int value) {
        long start = System.nanoTime();
        boolean found = set.contains(value);
        long end = System.nanoTime();
        System.out.printf("   %s: %d ms (contains %d: %b)%n", name, (end - start) / 1_000_000, value, found);
    }
}