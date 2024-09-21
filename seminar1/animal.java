package seminar1;

public class animal {
    public String name;
    public int age;

    public animal(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void displayInfo() {
        System.out.println("Animal Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        animal myAnimal = new animal("Leo", 3); // Создание объекта animal
        myAnimal.displayInfo(); // Вызов метода для вывода информации
    }
}