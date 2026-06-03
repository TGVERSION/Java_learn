package LR8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Пример 5 + Задание 2.3 — HTML-парсер с помощью библиотеки Jsoup.
 * Функции:
 *  - Подключение к сайту с обработкой ошибок и попытками переподключения.
 *  - Извлечение заголовков и ссылок со страницы.
 *  - Сохранение результатов в текстовый файл.
 */
public class HtmlParser {

    private static final String TARGET_URL  = "https://jsoup.org/";
    private static final String OUTPUT_FILE = "src/LR8/resources/html_result.txt";
    private static final int    MAX_RETRIES = 3;
    private static final int    TIMEOUT_MS  = 5000;

    public static void main(String[] args) {
        System.out.println("Подключение к: " + TARGET_URL);

        Document doc = connectWithRetry(TARGET_URL);
        if (doc == null) {
            System.out.println("Не удалось загрузить страницу после "
                    + MAX_RETRIES + " попыток.");
            return;
        }

        System.out.println("Страница загружена успешно.");

        // Извлекаем заголовок страницы
        String title = doc.title();
        System.out.println("Заголовок: " + title);

        // Извлекаем все ссылки с абсолютными URL
        Elements links = doc.select("a[href]");
        System.out.println("Найдено ссылок: " + links.size());

        StringBuilder result = new StringBuilder();
        result.append("Парсинг URL: ").append(TARGET_URL).append("\n");
        result.append("Дата: ").append(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))).append("\n");
        result.append("Заголовок страницы: ").append(title).append("\n");
        result.append("Ссылки:\n");

        int counter = 1;
        for (Element link : links) {
            String href = link.attr("abs:href");
            String text = link.text().isBlank() ? "(без текста)" : link.text();
            if (!href.isBlank()) {
                String line = String.format("%3d. %-40s -> %s", counter++, text, href);
                System.out.println(line);
                result.append(line).append("\n");
            }
        }

        // Сохраняем в файл
        saveToFile(result.toString());
    }

    // Обработка ошибок
    private static Document connectWithRetry(String url) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.printf("  Попытка %d/%d...%n", attempt, MAX_RETRIES);
                return Jsoup.connect(url)
                        .timeout(TIMEOUT_MS)
                        .userAgent("Mozilla/5.0")
                        .get();
            } catch (IOException e) {
                System.out.printf("  Ошибка (попытка %d): %s%n", attempt, e.getMessage());
                if (attempt < MAX_RETRIES) {
                    System.out.println("  Повторное подключение через 2 секунды...");
                    try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
                }
            }
        }
        return null;
    }

    // Сохраняет текст в файл
    private static void saveToFile(String content) {
        try {
            new File(OUTPUT_FILE).getParentFile().mkdirs();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                bw.write(content);
            }
            System.out.println("\nРезультаты сохранены в файл: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }
}