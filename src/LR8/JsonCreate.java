package LR8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;

/**
 * Пример 3 — Создание JSON-файла с помощью библиотеки json-simple.
 * Создаём файл employees.json со списком сотрудников.
 */
@SuppressWarnings("unchecked")
public class JsonCreate {

    private static final String JSON_PATH = "src/LR8/resources/employees.json";

    public static void main(String[] args) throws Exception {
        // Создаём массив сотрудников
        JSONArray employeesArray = new JSONArray();
        employeesArray.add(makeEmployee("Иванов Иван Иванович", "Программист", "IT", "90000"));
        employeesArray.add(makeEmployee("Петрова Анна Сергеевна", "Аналитик", "Финансы", "75000"));
        employeesArray.add(makeEmployee("Сидоров Алексей Петрович", "Менеджер", "HR", "80000"));

        // Оборачиваем в корневой объект
        JSONObject root = new JSONObject();
        root.put("employees", employeesArray);

        // Записываем в файл
        new File(JSON_PATH).getParentFile().mkdirs();
        try (FileWriter fw = new FileWriter(JSON_PATH)) {
            fw.write(root.toJSONString());
        }

        System.out.println("JSON-файл создан: " + JSON_PATH);
        System.out.println("Содержимое:\n" + root.toJSONString());
    }

    static JSONObject makeEmployee(String name, String position, String department, String salary) {
        JSONObject emp = new JSONObject();
        emp.put("name",       name);
        emp.put("position",   position);
        emp.put("department", department);
        emp.put("salary",     salary);
        return emp;
    }
}
