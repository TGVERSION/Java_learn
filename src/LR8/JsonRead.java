package LR8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * Пример 4 — Чтение JSON-файла с помощью библиотеки json-simple.
 */
public class JsonRead {

    private static final String JSON_PATH = "src/LR8/resources/employees.json";

    public static void main(String[] args) throws Exception {
        // Создаём парсер и читаем файл
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(JSON_PATH));

        System.out.println("Корневой ключ: employees");

        // Извлекаем массив сотрудников
        JSONArray employees = (JSONArray) root.get("employees");
        System.out.println("Всего сотрудников: " + employees.size());

        // Перебираем сотрудников и выводим информацию
        for (int i = 0; i < employees.size(); i++) {
            JSONObject emp = (JSONObject) employees.get(i);
            System.out.printf("Сотрудник %d:%n  Имя: %s%n  Должность: %s%n  Отдел: %s%n  Зарплата: %s руб.%n%n",
                    i + 1,
                    emp.get("name"),
                    emp.get("position"),
                    emp.get("department"),
                    emp.get("salary"));
        }
    }
}
