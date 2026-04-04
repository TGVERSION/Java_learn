package LR4;

public class Example6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {          // потомок Exception
            System.out.println("2 (RuntimeException)");
        } catch (Exception e) {                 // предок – только после потомков
            System.out.println("3 (Exception)");
        }
        System.out.println("4");
    }
}
