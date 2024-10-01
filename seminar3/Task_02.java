/*
Заполнить список десятью случайными числами.
Отсортировать список методом sort() и вывести его на экран.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Task_02 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            arr.add(rnd.nextInt(0, 100));
        }
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.sort(arr, Comparator.reverseOrder());
        System.out.println(arr);

    }

}
