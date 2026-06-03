package LR8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Задание 2.2 — Расширенный XML-менеджер списка сотрудников.
 * Функции:
 *   1 - Показать всех сотрудников
 *   2 - Добавить сотрудника
 *   3 - Поиск по отделу
 *   4 - Поиск по должности
 *   5 - Удалить сотрудника по имени
 *   0 - Выход
 */
public class XmlManager {

    private static final String XML_PATH = "src/LR8/resources/employees.xml";
    private static Document doc;

    public static void main(String[] args) throws Exception {
        loadDocument();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println(" 1. Показать всех сотрудников");
            System.out.println(" 2. Добавить сотрудника");
            System.out.println(" 3. Поиск по отделу");
            System.out.println(" 4. Поиск по должности");
            System.out.println(" 5. Удалить сотрудника по имени");
            System.out.println(" 0. Выход");
            System.out.print("Выберите действие: ");

            switch (sc.nextLine().trim()) {
                case "1" -> showAll();
                case "2" -> addEmployee(sc);
                case "3" -> searchByDepartment(sc);
                case "4" -> searchByPosition(sc);
                case "5" -> deleteEmployee(sc);
                case "0" -> running = false;
                default  -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
        System.out.println("До свидания!");
    }

    // Загрузка XML-документа из файла
    private static void loadDocument() throws Exception {
        File file = new File(XML_PATH);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        if (!file.exists()) {
            doc = builder.newDocument();
            doc.appendChild(doc.createElement("employees"));
            saveDocument();
            System.out.println("Создан новый XML-файл: " + XML_PATH);
        } else {
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Загружен файл: " + XML_PATH);
        }
    }

    // Сохранение документа в файл
    private static void saveDocument() throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(XML_PATH)));
    }

    // Показать всех сотрудников
    private static void showAll() {
        List<Element> list = getEmployeeElements();
        if (list.isEmpty()) {
            System.out.println("  Список сотрудников пуст.");
            return;
        }
        System.out.println("\nСписок сотрудников (" + list.size() + "):");
        for (int i = 0; i < list.size(); i++) {
            printEmployee(i + 1, list.get(i));
        }
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

        doc.getDocumentElement()
                .appendChild(XmlCreate.createEmployee(doc, name, position, department, salary));
        saveDocument();
        System.out.println("Сотрудник " + name + " добавлен.");
    }

    // Поиск по отделу
    private static void searchByDepartment(Scanner sc) {
        System.out.print(" Введите отдел: ");
        String query = sc.nextLine().trim().toLowerCase();
        List<Element> found = getEmployeeElements().stream()
                .filter(e -> getText(e, "department").toLowerCase().contains(query))
                .collect(Collectors.toList());
        printSearchResult(found, "отделу: " + query);
    }

    // Поиск по должности
    private static void searchByPosition(Scanner sc) {
        System.out.print(" Введите должность: ");
        String query = sc.nextLine().trim().toLowerCase();
        List<Element> found = getEmployeeElements().stream()
                .filter(e -> getText(e, "position").toLowerCase().contains(query))
                .collect(Collectors.toList());
        printSearchResult(found, "должности: " + query);
    }

    // Удалить сотрудника по имени
    private static void deleteEmployee(Scanner sc) throws Exception {
        System.out.print(" Введите имя сотрудника для удаления: ");
        String name = sc.nextLine().trim();
        boolean deleted = false;
        for (Element emp : getEmployeeElements()) {
            if (getText(emp, "name").equalsIgnoreCase(name)) {
                emp.getParentNode().removeChild(emp);
                deleted = true;
                break;
            }
        }
        if (deleted) {
            saveDocument();
            System.out.println("Сотрудник " + name + " удалён.");
        } else {
            System.out.println("Сотрудник с именем " + name + " не найден.");
        }
    }

    // Вспомогательные методы
    private static List<Element> getEmployeeElements() {
        NodeList nodes = doc.getElementsByTagName("employee");
        return IntStream.range(0, nodes.getLength())
                .mapToObj(i -> (Element) nodes.item(i))
                .collect(Collectors.toList());
    }

    private static String getText(Element parent, String tag) {
        NodeList nodes = parent.getElementsByTagName(tag);
        return nodes.getLength() > 0 ? nodes.item(0).getTextContent() : "";
    }

    private static void printEmployee(int num, Element emp) {
        System.out.printf("  %d. %-30s | %-15s | %-12s | %s руб.%n",
                num,
                getText(emp, "name"),
                getText(emp, "position"),
                getText(emp, "department"),
                getText(emp, "salary"));
    }

    private static void printSearchResult(List<Element> found, String criteria) {
        System.out.println("\nРезультаты поиска по " + criteria + ":");
            if (found.isEmpty()) {
            System.out.println("  Ничего не найдено.");
        } else {
            for (int i = 0; i < found.size(); i++) {
                printEmployee(i + 1, found.get(i));
            }
        }
    }
}