// public class Task1 {
// public static void main(String[] args) {
// System.out.println("Hello, homework, task1!");
// }
// }

// -----------------------------------------------------------
// Задание 1. Нахождение факториала числа
// Напишите метод factorial, который принимает число n и возвращает его
// факториал. Если число n < 0, метод должен вернуть -1.

// class Answer {
// public int factorial(int n) {
// // Введите свое решение ниже
// if (n < 0) {
// return -1;
// }
// int result = 1;
// for (int i = 2; i <= n; i++) {
// result *= i;
// }
// return result;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Printer {
// public static void main(String[] args) {
// int n = 5;
// if (args.length > 0) {
// n = Integer.parseInt(args[0]);
// }
// // Вывод результата на экран
// Answer ans = new Answer();
// int itresume_res = ans.factorial(n);
// System.out.println(itresume_res);
// }
// }

// --------------------------------------------------------------------------------------
// Задача 2. Вывод всех четных чисел от 1 до 100
// Напишите метод printEvenNums, который выведет на экран все четные числа
// в промежутке от 1 до 100, каждое на новой строке.

// class Answer {
// public static void printEvenNums() {
// // Напишите свое решение ниже
// for (int i = 2; i <= 100; i += 2) {
// System.out.println(i);
// }
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Printer {
// public static void main(String[] args) {
// Answer.printEvenNums();
// }
// }

// ---------------------------------------------------------------------------------------

// Задача 3. Подсчет суммы цифр числа
// Напишите метод sumDigits, который принимает целое число n и возвращает
// сумму его цифр.

// class Answer {
// public int sumDigits(int n) {
// // Введите свое решение ниже
// int sum = 0;
// while (n != 0) {
// sum += n % 10;
// n /= 10;
// }
// return sum;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Printer {
// public static void main(String[] args) {
// int n = 12345;
// if (args.length > 0) {
// n = Integer.parseInt(args[0]);
// }
// // Вывод результата на экран
// Answer ans = new Answer();
// int itresume_res = ans.sumDigits(n);
// System.out.println(itresume_res);
// }
// }

// --------------------------------------------------------------------------------------
// Задача 4*. Нахождение максимального из трех чисел
// Реализуйте две функции:
// 1. Функция findMaxOfTwo должна принимать два числа и возвращать
// максимальное из них, используя только знак сравнения.
// 2. Функция findMaxOfThree должна принимать три числа и находить
// максимальное из них, используя первую функцию.

class Answer {
    // Функция для нахождения максимума из двух чисел
    public int findMaxOfTwo(int a, int b) {
        return (a > b) ? a : b;
    }

    // Функция для нахождения максимума из трех чисел
    public int findMaxOfThree(int a, int b, int c) {
        // Сначала находим максимум между a и b, а затем сравниваем его с c
        return findMaxOfTwo(findMaxOfTwo(a, b), c);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int a = 5, b = 10, c = 3;
        if (args.length == 3) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            c = Integer.parseInt(args[2]);
        }
        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.findMaxOfThree(a, b, c);
        System.out.println(itresume_res);
    }
}