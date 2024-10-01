package hw3;

import java.util.ArrayList;
import java.util.Arrays;

/* Напишите метод, который принимает целочисленный массив и возвращает
новый массив, содержащий только уникальные элементы из исходного
массива.
Пример:
[1, 2, 2, 3, 4, 4, 5]
Результат:
[1, 2, 3, 4, 5]
 */

class Task_02 {
    public static int[] getUniqueElements(int[] a) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : a) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        // Преобразуем ArrayList в массив
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}

class Printer1 {
    public static void main(String[] args) {
        int[] a;
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[] { 1, 2, 2, 3, 4, 4, 5 };
        } else {
            a = Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray();
        }

        // Выводим входной массив для отладки
        System.out.println("Входной массив: " + Arrays.toString(a));

        // Вызов метода getUniqueElements
        String itresume_res = Arrays.toString(Task_02.getUniqueElements(a));
        System.out.println(itresume_res); // Ожидаемый вывод: [1, 2, 3, 4, 5]
    }
}
