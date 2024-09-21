package seminar1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main { // Изменили имя класса на заглавную букву
    public static void main(String[] args) throws IOException {

        // вызов методов, чтобы убрать предупреждения
        task1(); // Вызов метода task1()
        task7();
    }

    public static void task7() throws IOException {
        // Создаем объект FileWriter для записи в файл "output.txt"
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write("Hello World");
            // flush не обязателен, так как try-with-resources автоматически закроет файл
        }
    }

    public static String task6() {
        String s = "Добро пожаловать на курс по Java";
        String[] split = s.split(" ");
        String res = "";
        for (int i = split.length - 1; i >= 0; i--) {
            res += split[i] + " "; // Правильное объединение слов
        }
        return res.trim(); // Убираем пробел в конце
    }

    public static void cycle() {
        while (true) {
            task2();
        }
    }

    public static void task2() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter your name: ");
            String name = sc.next();

            if (name.startsWith("q"))
                System.exit(0);

            if (name.startsWith("Al")) {
                System.out.println("Are you Alex?");
            } else if (name.startsWith("B")) {
                System.out.println("Are you Bob?");
            } else if (name.startsWith("C")) {
                System.out.println("Are you Carol?");
            } else {
                System.out.println("Hello!");
            }
        }
    }

    private static void task1() {
        System.out.println("Hello World");

        // Получение текущего времени
        LocalTime now = LocalTime.now(); // Переменная используется для получения текущего времени
        System.out.println("Current time: " + now); // Выводим значение переменной now

        // Форматирование даты и времени
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("Дата: dd MMM yyyy г., время: HH ч. mm мин. ss сек.");
        System.out.println(formatter.format(LocalDateTime.now()));
    }
}
