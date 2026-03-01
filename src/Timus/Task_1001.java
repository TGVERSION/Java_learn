import java.util.Scanner;
import java.util.ArrayList;

public class Task_1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> nums = new ArrayList<>();
        while (sc.hasNextLong()) {
            nums.add(sc.nextLong());
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            double root = Math.sqrt(nums.get(i));
            System.out.printf("%.4f\n", root);
        }
    }
}