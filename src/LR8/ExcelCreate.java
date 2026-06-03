package LR8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Пример 6 — Создание Excel-файла с помощью Apache POI.
 * Создаёт таблицу "Сотрудники" с заголовками и строками данных.
 */
public class ExcelCreate {

    static final String EXCEL_PATH = "src/LR8/resources/employees.xlsx";

    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {

            // Создаём лист "Сотрудники"
            Sheet sheet = workbook.createSheet("Сотрудники");

            // Стиль для заголовков (жирный шрифт + цвет фона)
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            // Заголовок таблицы
            Row header = sheet.createRow(0);
            String[] columns = {"Имя", "Должность", "Отдел", "Зарплата (руб.)"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // Данные — список сотрудников
            Object[][] data = {
                    {"Иванов Иван Иванович", "Программист", "IT", 90000.0},
                    {"Петрова Анна Сергеевна", "Аналитик", "Финансы", 75000.0},
                    {"Сидоров Алексей Петрович", "Менеджер", "HR", 80000.0},
                    {"Козлов Денис Викторович", "Тестировщик", "IT", 70000.0},
                    {"Новикова Ольга Игоревна", "Бухгалтер", "Финансы", 68000.0},
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((String) data[i][0]);
                row.createCell(1).setCellValue((String) data[i][1]);
                row.createCell(2).setCellValue((String) data[i][2]);
                row.createCell(3).setCellValue((Double) data[i][3]);
            }

            // Авторазмер колонок
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Записываем файл
            new File(EXCEL_PATH).getParentFile().mkdirs();
            try (FileOutputStream fos = new FileOutputStream(EXCEL_PATH)) {
                workbook.write(fos);
            }

            System.out.println("Excel-файл создан: " + EXCEL_PATH);

        } catch (IOException e) {
            System.out.println("Ошибка создания Excel-файла: " + e.getMessage());
        }
    }
}