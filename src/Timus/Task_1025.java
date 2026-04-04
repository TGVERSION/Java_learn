package Timus;

import java.util.Arrays;
import java.util.Scanner;

public class Task_1025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] groups = new int[n];

        for (int i = 0; i < n; i++) {
            groups[i] = in.nextInt();
        }
        in.close();

        Arrays.sort(groups);
        int needGroups = n / 2 + 1;
        int minVotes = 0;

        for (int i = 0; i < needGroups; i++) {
            minVotes += groups[i] / 2 + 1;
        }

        System.out.println(minVotes);
    }
}
