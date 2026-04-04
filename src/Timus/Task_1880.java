package Timus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_1880 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        Set<Long> set1 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextLong());
        }

        int n2 = sc.nextInt();
        Set<Long> set2 = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            long val = sc.nextLong();
            if (set1.contains(val)) {
                set2.add(val);
            }
        }

        int n3 = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n3; i++) {
            long val = sc.nextLong();
            if (set2.contains(val)) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
