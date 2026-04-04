package LR3;

import java.util.HashMap;
import java.util.Map;

public class HashMapTask {
    public static void main(String[] args) {
        // 1. Заполняем HashMap 10 объектами
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map.put(i, "Строка" + i);
        }

        // 2. Находим строки с ключом > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        // 3. Если ключ = 0, вывести строки через запятую (в этом случае ключа 0 нет)
        if (map.containsKey(0)) {
            System.out.print("Строки с ключом 0: ");
            // можно собрать через запятую, но здесь просто вывод
            System.out.println(map.get(0));
        } else {
            System.out.println("Ключа 0 нет в HashMap.");
        }

        // 4. Перемножить все ключи, где длина строки > 5
        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }
        if (found) {
            System.out.println("Произведение ключей (длина строки > 5): " + product);
        } else {
            System.out.println("Нет строк с длиной больше 5.");
        }
    }
}

