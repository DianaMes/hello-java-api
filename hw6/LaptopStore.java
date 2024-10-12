package hw6;

// Задание 1. Поиск ноутбуков

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
// методы.
// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или
// критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
// фильтрации можно хранить в Map.
// Например:
// Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// -Далее нужно запросить минимальные значения для указанных критериев -
// сохранить параметры фильтрации можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие
// по условиям.

import java.util.*;

class Laptop {
    private int ram; // ОЗУ
    private int hdd; // Объем ЖД
    private String os; // Операционная система
    private String color; // Цвет

    public Laptop(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop [RAM: " + ram + "GB, HDD: " + hdd + "GB, OS: " + os + ", Color: " + color + "]";
    }
}

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
                new Laptop(8, 512, "Windows", "Black"),
                new Laptop(16, 1024, "Windows", "Silver"),
                new Laptop(8, 256, "Linux", "Black"),
                new Laptop(32, 2048, "MacOS", "Silver")));

        Map<String, String> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueFiltering = true;

        while (continueFiltering) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальное значение ОЗУ (в ГБ):");
                    filters.put("ram", scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Введите минимальное значение объема ЖД (в ГБ):");
                    filters.put("hdd", scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    filters.put("os", scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.nextLine());
                    break;
                default:
                    System.out.println("Неправильный выбор.");
            }

            System.out.println("Хотите добавить еще один критерий? (да/нет)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("да")) {
                continueFiltering = false;
            }
        }

        filterLaptops(laptops, filters);
        scanner.close();
    }

    public static void filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            if (filters.containsKey("ram") && laptop.getRam() < Integer.parseInt(filters.get("ram"))) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.getHdd() < Integer.parseInt(filters.get("hdd"))) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase(filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase(filters.get("color"))) {
                matches = false;
            }

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
