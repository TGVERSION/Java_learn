package LR8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Пример 7 + Задание 2.4 — Чтение Excel-файла с улучшенной обработкой ошибок.
 *
 * Улучшения (Задание 2.4):
 *  - Проверка существования файла перед открытием.
 *  - Проверка расширения файла (.xlsx).
 *  - Проверка наличия листа по имени.
 *  - Подробные сообщения об ошибках с рекомендациями.
 *  - Возможность повторного запуска после исправления ошибки.
 */
public class ExcelRead {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\nВведите путь к Excel-файлу (или 'exit' для выхода): ");
            String input = sc.nextLine().trim();

            // Убираем кавычки, если путь вставлен с ними
            if (input.startsWith("\"") && input.endsWith("\"")) {
                input = input.substring(1, input.length() - 1);
            }

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            String result = readExcelFile(input);
            if (result != null) {
                System.out.println(result);
                System.out.print("Прочитать другой файл? (да/нет): ");
                running = sc.nextLine().trim().equalsIgnoreCase("да");
            } else {
                System.out.println("Попробуйте снова или введите 'exit'.");
            }
        }
    }

    // Читает Excel-файл с обработкой ошибок
    private static String readExcelFile(String filePath) {

        // Проверка: путь не пустой
        if (filePath == null || filePath.isBlank()) {
            System.out.println("Ошибка: путь к файлу не может быть пустым.");
            System.out.println("Введите полный путь, например: src/LR8/resources/employees.xlsx");
            return null;
        }

        File file = new File(filePath);

        // Проверка: файл существует
        if (!file.exists()) {
            System.out.println("Ошибка: файл не найден -> " + filePath);
            System.out.println("Проверьте правильность пути и имени файла.");
            return null;
        }

        // Проверка: это файл, а не директория
        if (!file.isFile()) {
            System.out.println("Ошибка: указанный путь является директорией, а не файлом.");
            System.out.println("Укажите полный путь включая имя файла.");
            return null;
        }

        // Проверка: расширение .xlsx
        if (!filePath.toLowerCase().endsWith(".xlsx")) {
            System.out.println("Ошибка: файл должен быть в формате .xlsx");
            System.out.println("Убедитесь, что файл сохранён как Excel (.xlsx).");
            return null;
        }

        // Проверка: файл доступен для чтения
        if (!file.canRead()) {
            System.out.println("Ошибка: нет прав на чтение файла -> " + filePath);
            System.out.println("Проверьте права доступа к файлу.");
            return null;
        }

        // Чтение файла
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Проверка: файл содержит хотя бы один лист
            if (workbook.getNumberOfSheets() == 0) {
                System.out.println("Ошибка: файл Excel не содержит ни одного листа.");
                return null;
            }

            // Ищем лист "Сотрудники" или берём первый
            Sheet sheet = workbook.getSheet("Сотрудники");
            if (sheet == null) {
                System.out.println("Лист 'Сотрудники' не найден. Читаем первый лист: "
                        + workbook.getSheetName(0));
                sheet = workbook.getSheetAt(0);
            }

            // Проверка: лист не пустой
            if (sheet.getPhysicalNumberOfRows() == 0) {
                System.out.println("Ошибка: лист " + sheet.getSheetName() + " пустой.");
                return null;
            }

            // Читаем данные
            StringBuilder sb = new StringBuilder();
            sb.append("\nФайл успешно прочитан: ").append(filePath).append("\n");
            sb.append("Лист: ").append(sheet.getSheetName()).append("\n");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    sb.append(String.format("%-25s", getCellValueAsString(cell)));
                }
                sb.append("\n");
            }

            return sb.toString();

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            System.out.println("Убедитесь, что файл не открыт в другой программе.");
            return null;
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
            System.out.println("Файл может быть повреждён.");
            return null;
        }
    }

    // получение значения ячейки в виде строки
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING  -> cell.getStringCellValue();
            case NUMERIC -> DateUtil.isCellDateFormatted(cell)
                    ? cell.getLocalDateTimeCellValue().toLocalDate().toString()
                    : String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            case BLANK   -> "";
            default      -> "?";
        };
    }
}