package LR8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Задание 2.2 — Расширенный JSON-менеджер списка сотрудников.
 * Функции:
 *   1 - Показать всех сотрудников
 *   2 - Поиск по отделу
 *   3 - Добавить сотрудника
 *   4 - Удалить сотрудника по имени
 *   0 - Выход
 */
@SuppressWarnings("unchecked")
public class JsonManager {

    private static final String JSON_PATH = "src/LR8/resources/employees.json";
    private static JSONObject root;
    private static JSONArray employees;

    public static void main(String[] args) throws Exception {
        load();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println(" 1. Показать всех сотрудников");
            System.out.println(" 2. Поиск по отделу");
            System.out.println(" 3. Добавить сотрудника");
            System.out.println(" 4. Удалить сотрудника по имени");
            System.out.println(" 0. Выход");
            System.out.print("Выберите действие: ");

            switch (sc.nextLine().trim()) {
                case "1" -> showAll();
                case "2" -> searchByDepartment(sc);
                case "3" -> addEmployee(sc);
                case "4" -> deleteEmployee(sc);
                case "0" -> running = false;
                default  -> System.out.println("Неверный выбор.");
            }
        }
        System.out.println("До свидания!");
    }

    // Загрузка JSON из файла
    private static void load() throws Exception {
        root      = (JSONObject) new JSONParser().parse(new FileReader(JSON_PATH));
        employees = (JSONArray) root.get("employees");
        System.out.println("Загружен файл: " + JSON_PATH
                + " (" + employees.size() + " сотрудников)");
    }

    // Сохранение JSON в файл
    private static void save() throws Exception {
        try (FileWriter fw = new FileWriter(JSON_PATH)) {
            fw.write(root.toJSONString());
        }
    }

    // Показать всех сотрудников
    private static void showAll() {
        System.out.println("\nСписок сотрудников (" + employees.size() + "):");
        if (employees.isEmpty()) {
            System.out.println(" Список пуст.");
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            printEmployee(i + 1, (JSONObject) employees.get(i));
        }
    }

    // Поиск по отделу
    private static void searchByDepartment(Scanner sc) {
        System.out.print(" Введите отдел: ");
        String dept = sc.nextLine().trim();

        System.out.println("\nРезультаты поиска по отделу: " + dept);

        // Стало:
        boolean found = false;
        for (Object o : employees) {
            JSONObject emp = (JSONObject) o;
            if (dept.equalsIgnoreCase((String) emp.get("department"))) {
                printEmployee(-1, emp);
                found = true;
            }
        }

        if (!found) System.out.println("  Ничего не найдено.");
    }

    // Добавить сотрудника
    private static void addEmployee(Scanner sc) throws Exception {
        System.out.print(" Имя: ");
        String name = sc.nextLine().trim();
        System.out.print(" Должность: ");
        String position = sc.nextLine().trim();
        System.out.print(" Отдел: ");
        String department = sc.nextLine().trim();
        System.out.print(" Зарплата: ");
        String salary = sc.nextLine().trim();

        JSONObject newEmp = new JSONObject();
        newEmp.put("name", name);
        newEmp.put("position", position);
        newEmp.put("department", department);
        newEmp.put("salary", salary);
        employees.add(newEmp);

        save();
        System.out.println("Сотрудник " + name + " добавлен.");
    }

    // Удалить сотрудника по имени
    private static void deleteEmployee(Scanner sc) throws Exception {
        System.out.print(" Введите имя для удаления: ");
        String name = sc.nextLine().trim();

        Iterator<?> it = employees.iterator();
        boolean deleted = false;
        while (it.hasNext()) {
            JSONObject emp = (JSONObject) it.next();
            if (name.equalsIgnoreCase((String) emp.get("name"))) {
                it.remove();
                deleted = true;
                break;
            }
        }

        if (deleted) {
            save();
            System.out.println("Сотрудник " + name + " удалён.");
        } else {
            System.out.println("Сотрудник " + name + " не найден.");
        }
    }

    // Вывод сотрудника
    private static void printEmployee(int num, JSONObject emp) {
        String prefix = num > 0 ? num + ". " : "   ";
        System.out.printf(" %s%-30s | %-15s | %-12s | %s руб.%n",
                prefix,
                emp.get("name"),
                emp.get("position"),
                emp.get("department"),
                emp.get("salary"));
    }
}
