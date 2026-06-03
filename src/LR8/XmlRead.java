package LR8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Пример 2 — Чтение XML-файла через DOM (DocumentBuilder).
 * Читаем employees.xml и выводим всех сотрудников в консоль.
 */
public class XmlRead {

    private static final String XML_PATH = "src/LR8/resources/employees.xml";

    public static void main(String[] args) throws Exception {
        // Открываем и парсим XML-файл
        File file = new File(XML_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        // Выводим имя корневого элемента
        System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

        // Получаем все элементы <employee> и выводим их содержимое
        NodeList employees = doc.getElementsByTagName("employee");
        System.out.println("Всего сотрудников: " + employees.getLength());

        for (int i = 0; i < employees.getLength(); i++) {
            Element emp = (Element) employees.item(i);
            String name = emp.getElementsByTagName("name").item(0).getTextContent();
            String position = emp.getElementsByTagName("position").item(0).getTextContent();
            String department = emp.getElementsByTagName("department").item(0).getTextContent();
            String salary = emp.getElementsByTagName("salary").item(0).getTextContent();

            System.out.printf("Сотрудник %d:%n  Имя: %s%n  Должность: %s%n  Отдел: %s%n  Зарплата: %s руб.%n%n",
                    i + 1, name, position, department, salary);
        }
    }
}