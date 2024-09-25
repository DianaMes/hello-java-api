package hw2;

// Задание 1. Формирование URL с параметрами
// Дана строка базового URL:
// https://example.com/search?
// Сформируйте полный URL, добавив к нему параметры для поиска. Параметры
// передаются в виде строки, где ключи и значения разделены =, а пары
// ключ-значение разделены &. Если значение null, то параметр не должен
// попадать в URL.
// Пример:
// params = "query=java&sort=desc&filter=null"
// Результат:
// https://example.com/search?query=java&sort=desc

// public class Main {

// static class URLBuilder {
// public static String buildURL(String baseURL, String params) {
// // Разделим параметры на пары ключ-значение
// String[] pairs = params.split("&");
// StringBuilder result = new StringBuilder(baseURL);

// boolean firstParam = true; // флаг для добавления вопросительного знака или &

// // Пробежимся по каждой паре
// for (String pair : pairs) {
// String[] keyValue = pair.split("=");

// // Если значение не "null", добавляем его к URL
// if (keyValue.length == 2 && !"null".equals(keyValue[1])) {
// if (!firstParam) {
// result.append("&");
// }
// result.append(keyValue[0]).append("=").append(keyValue[1]);
// firstParam = false; // после первого параметра добавляем &
// }
// }

// return result.toString();
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Printer {
// public static void main(String[] args) {
// String baseURL = "";
// String params = "";

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// baseURL = "https://example.com/search?";
// params = "query=java&sort=desc&filter=null";
// } else {
// baseURL = args[0];
// params = args[1];
// }

// // URLBuilder ans = new URLBuilder();
// // System.out.println(ans.buildURL(baseURL, params));
// System.out.println(URLBuilder.buildURL(baseURL, params));
// }
// }

// }

// ----------------------------------------------------------------------------
// Задача 2. Создание CSV-строки из массива объектов
// Дан массив объектов, где каждый объект представляет собой строку данных, и
// массив заголовков. Создайте строку CSV, где строки данных разделяются новой
// строкой, а значения в строках разделяются запятыми.
// Пример:
// String[] headers = {"Name", "Age", "City"};
// String[][] data = {
// {"John", "30", "New York"},
// {"Alice", "25", "Los Angeles"},
// {"Bob", "35", "Chicago"}
// };
// Результат:
// Name,Age,City
// John,30,New York
// Alice,25,Los Angeles
// Bob,35,Chicago

// public class Main {
// static class CSVGenerator {
// public static String generateCSV(String[] headers, String[][] data) {
// StringBuilder csv = new StringBuilder();
// // Добавление заголовков
// csv.append(String.join(",", headers)).append("\n");
// // Добавление данных
// for (String[] row : data) {
// csv.append(String.join(",", row)).append("\n");
// }
// return csv.toString().trim(); // Удалить последнюю новую строку
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Printer {
// public static void main(String[] args) {
// String[] headers = {};
// String[][] data = {};
// if (args.length == 0) {
// headers = new String[] { "Name", "Age", "City" };
// data = new String[][] {
// { "John", "30", "New York" },
// { "Alice", "25", "Los Angeles" },
// { "Bob", "35", "Chicago" }
// };
// } else {
// // Преобразование строковых параметров в массивы
// // Пример обработки данных можно дополнить в зависимости от формата args
// }
// // CSVGenerator ans = new CSVGenerator();
// System.out.println(CSVGenerator.generateCSV(headers, data));
// }
// }

// }

// ----------------------------------------------------------------------------------------
// Задача 3. Удаление пустых строк из текста
// Дана строка с несколькими строками текста, разделенными переводами строки.
// Напишите метод, который удаляет все пустые строки из текста.
// Пример:
// line1
// line2
// line3
// Результат:
// line1
// line2
// line3

// public class Main {
// static class TextCleaner {
// public static String removeEmptyLines(String text) {
// String[] lines = text.split("\n");
// StringBuilder cleanedText = new StringBuilder();
// for (String line : lines) {
// if (!line.trim().isEmpty()) {
// if (cleanedText.length() > 0) {
// cleanedText.append("\n");
// }
// cleanedText.append(line);
// }
// }
// return cleanedText.toString();
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Printer {
// public static void main(String[] args) {
// String text = "";
// if (args.length == 0) {
// text = "line1\n\nline2\n\nline3";
// } else {
// text = args[0];
// }

// System.out.println(TextCleaner.removeEmptyLines(text));
// }
// }
// }

// ---------------------------------------------------------------------------------
// Задача 4. Логирование операций с массивом во время поиска
// минимального и максимального элементов
// Реализуйте метод поиска минимального и максимального элементов массива.
// После нахождения каждого элемента (минимального и максимального),
// сделайте запись в лог-файл log.txt в формате год-месяц-день
// час:минуты {минимальный элемент}, {максимальный элемент}.
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    static class ArrayOperations {
        private static File log;
        private static FileWriter fileWriter;

        public static void findMinMax(int[] arr) {
            try {
                log = new File("log.txt");
                log.createNewFile();
                fileWriter = new FileWriter(log);
                int min = arr[0];
                int max = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                    logStep(min, max);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private static void logStep(int min, int max) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String timestamp = dateFormat.format(new Date());
                fileWriter.write(timestamp + " " + min + ", " + max +
                        "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public class Printer {
        public static void main(String[] args) {
            int[] arr = {};
            if (args.length == 0) {
                arr = new int[] { 9, 4, 8, 3, 1 };
            } else {
                arr = Arrays.stream(args[0].split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            // ArrayOperations = new ArrayOperations();
            ArrayOperations.findMinMax(arr);
            try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}