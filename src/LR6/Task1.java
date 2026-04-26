package LR6;

import java.time.LocalTime;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10000) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10000) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
