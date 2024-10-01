import java.util.ArrayList;
import java.util.Arrays;
// import java.util.List;

/*Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке.

 */

public class Task_03 {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>();
        String[] temp = { "Венера", "Земля", "Марс", "Венера", "Юпитер" };
        planets.addAll(Arrays.asList(temp));
        // List<String> tempor = List.of("Венера", "Земля", "Марс", "Венера", "Юпитер");
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < planets.size(); i++) {
            String planet = planets.get(i);
            if (!result.contains(planet)) {

                result.add(planet);
                int count = 0;
                for (int j = i; j < planets.size(); j++) {
                    if (planets.get(j).equals(planet)) {
                        count++;
                    }
                }
                sb.append(planet).append(" : ").append(count).append("\n");
            }

        }
        System.out.println(sb);
        System.out.println(delete(sb));
    }

    public static StringBuilder delete(StringBuilder sb) {
        String temp = sb.toString();
        StringBuilder result = new StringBuilder();
        String[] split = temp.split("\n");
        for (String s : split) {
            if (s.split(" : ")[1].equals("1"))
                result.append(s).append("\n");
        }
        return result;
    }

}
