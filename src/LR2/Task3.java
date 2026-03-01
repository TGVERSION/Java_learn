package LR2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ (целое число):");
        int key = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        // Шифрование
        String encrypted = caesarCipher(text, key);
        System.out.println("Текст после преобразования: " + encrypted);

        // Запрос на обратное преобразование
        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                String decrypted = caesarCipher(encrypted, -key);
                System.out.println("Обратное преобразование: " + decrypted);
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ (y/n)");
            }
        }
        scanner.close();
    }

    // Метод для шифрования/дешифрования сдвигом
    public static String caesarCipher(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            // Сдвигаем символ
            result.append((char) (c + shift));
        }
        return result.toString();
    }
}