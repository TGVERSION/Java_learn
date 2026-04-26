package LR6;

import java.util.concurrent.atomic.AtomicInteger;

public class Task5 {

    public static int findMax(int[] array) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        AtomicInteger globalMax = new AtomicInteger(Integer.MIN_VALUE);

        int chunkSize = (array.length + cores - 1) / cores;

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);

            if (start >= array.length) break;

            threads[i] = new Thread(() -> {
                int localMax = array[start];
                for (int j = start + 1; j < end; j++) {
                    if (array[j] > localMax) {
                        localMax = array[j];
                    }
                }
                // Атомарно обновляем глобальный максимум
                int current;
                do {
                    current = globalMax.get();
                } while (localMax > current && !globalMax.compareAndSet(current, localMax));
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) t.join();
        }

        return globalMax.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {3, 7, 1, 15, 9, 22, 5, 18, 11, 2, 99, 44, 67};

        System.out.println("Массив: ");
        for (int n : array) System.out.print(n + " ");

        System.out.println("\nКоличество ядер: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Максимальный элемент: " + findMax(array));
    }
}
