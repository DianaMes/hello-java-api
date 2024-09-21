package seminar1;

import java.time.LocalDateTime;

public class task1 {
    public static void main(String[] args) {
        System.out.println("Hello, my love");
        LocalDateTime now = LocalDateTime.now().withNano(0);

        // System.out.println("Current time: " + now);
        System.out.println(now);
    }

}
