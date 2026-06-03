package LR8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Пример 1 — Создание XML-файла с помощью DOM API.
 * Создаём файл employees.xml со списком сотрудников.
 */
public class XmlCreate {

    private static final String XML_PATH = "src/LR8/resources/employees.xml";

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        // Корневой элемент <employees>
        Element root = doc.createElement("employees");
        doc.appendChild(root);

        // Добавляем сотрудников
        root.appendChild(createEmployee(doc,
                "Иванов Иван Иванович", "Программист", "IT", "90000"));
        root.appendChild(createEmployee(doc,
                "Петрова Анна Сергеевна", "Аналитик", "Финансы", "75000"));
        root.appendChild(createEmployee(doc,
                "Сидоров Алексей Петрович", "Менеджер", "HR", "80000"));

        // Записываем DOM в файл через Transformer
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        new File(XML_PATH).getParentFile().mkdirs();
        transformer.transform(new DOMSource(doc), new StreamResult(new File(XML_PATH)));

        System.out.println("XML-файл создан: " + XML_PATH);
    }

    static Element createEmployee(Document doc, String name, String position,
                                  String department, String salary) {
        Element emp = doc.createElement("employee");

        Element nameEl = doc.createElement("name");
        nameEl.setTextContent(name);

        Element posEl = doc.createElement("position");
        posEl.setTextContent(position);

        Element deptEl = doc.createElement("department");
        deptEl.setTextContent(department);

        Element salEl = doc.createElement("salary");
        salEl.setTextContent(salary);

        emp.appendChild(nameEl);
        emp.appendChild(posEl);
        emp.appendChild(deptEl);
        emp.appendChild(salEl);
        return emp;
    }
}