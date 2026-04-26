package LR6;

import java.util.concurrent.atomic.AtomicLong;

public class Task6 {

    public static long findSum(int[] array) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        AtomicLong globalSum = new AtomicLong(0);

        int chunkSize = (array.length + cores - 1) / cores;

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);

            if (start >= array.length) break;

            threads[i] = new Thread(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                globalSum.addAndGet(localSum);
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) t.join();
        }

        return globalSum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {3, 7, 1, 15, 9, 22, 5, 18, 11, 2, 99, 44, 67};

        System.out.println("Массив: ");
        for (int n : array) System.out.print(n + " ");

        System.out.println("\nКоличество ядер: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Сумма элементов: " + findSum(array));
    }
}
