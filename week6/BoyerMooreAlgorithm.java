import java.util.Scanner;

public class Main {

    public static int marsExploration(String s) {
        int changedCount = 0;
        String expected = "SOS";

        for (int i = 0; i < s.length(); i++) {
            // Compare each character with the corresponding character in "SOS"
            if (s.charAt(i) != expected.charAt(i % 3)) {
                changedCount++;
            }
        }

        return changedCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(marsExploration(s));
        }

        scanner.close();
    }
}
