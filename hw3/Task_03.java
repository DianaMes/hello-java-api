package hw3;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Реализуйте метод, который принимает на вход массив строк и возвращает
новый массив, содержащий только строки, длина которых больше 3 символов.
Пример:
["cat", "elephant", "dog", "giraffe"]
Результат:
["elephant", "giraffe"]
 */

class Task_03 {
    public static String[] filterShortStrings(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : arr) {
            if (s.length() > 3) { // Сохраняем строки длиной больше 3 символов
                result.add(s);
            }
        }
        // Преобразуем ArrayList в массив
        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}

class Printer2 {
    public static void main(String[] args) {
        String[] arr;
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new String[] { "cat", "elephant", "dog", "giraffe" };
        } else {
            // Измените разделитель на ","
            arr = args[0].split(","); // Используйте запятую без пробела
        }
        // Исправляем на правильное имя класса
        String itresume_res = Arrays.toString(Task_03.filterShortStrings(arr));
        System.out.println(itresume_res);
    }
}