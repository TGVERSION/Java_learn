package LR3;

public class RecursionExamples {
    // Пример 1
    public static void example1(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20) {
            example1(2 * x + 1);
        }
    }

    // Пример 2
    public static void example2(int x) {
        if ((2 * x + 1) < 20) {
            example2(2 * x + 1);
        }
        System.out.println("x=" + x);
    }

    // Пример 3
    private static int step = 0;

    private static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }

    public static void example3(int x) {
        space();
        System.out.println("" + x + " -> ");
        step++;
        if ((2 * x + 1) < 20) {
            example3(2 * x + 1);
        }
        step--;
        space();
        System.out.println("" + x + " <-");
    }

    // Пример 4
    public static int factorial(int n) {
        int result;
        if (n == 1) return 1;
        else {
            result = factorial(n - 1) * n;
            return result;
        }
    }

    // Пример 5
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    // Дополнительно: вывод дерева рекурсивных вызовов для примера 5
    private static int treeStep = 0;

    private static void treeSpace() {
        for (int i = 0; i < treeStep; i++) {
            System.out.print("  ");
        }
    }

    public static int fibonacciTree(int n) {
        treeSpace();
        System.out.println("fib(" + n + ")");
        if (n == 0) {
            treeSpace();
            System.out.println("-> 0");
            return 0;
        }
        if (n == 1) {
            treeSpace();
            System.out.println("-> 1");
            return 1;
        }
        treeStep++;
        int left = fibonacciTree(n - 2);
        int right = fibonacciTree(n - 1);
        treeStep--;
        int result = left + right;
        treeSpace();
        System.out.println("-> " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Пример 1 ===");
        example1(1);

        System.out.println("\n=== Пример 2 ===");
        example2(1);

        System.out.println("\n=== Пример 3 ===");
        example3(1);

        System.out.println("\n=== Пример 4 ===");
        System.out.println("5! = " + factorial(5));

        System.out.println("\n=== Пример 5 ===");
        System.out.println("fibonacci(6) = " + fibonacci(6));

        System.out.println("\n=== Дерево вызовов для fibonacci(4) ===");
        fibonacciTree(4);
    }
}
