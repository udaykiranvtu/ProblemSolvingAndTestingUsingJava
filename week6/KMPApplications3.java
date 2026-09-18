import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();

            // Use a HashSet to store characters of string a
            Set<Character> set = new HashSet<>();
            for (char c : a.toCharArray()) {
                set.add(c);
            }

            boolean found = false;
            for (char c : b.toCharArray()) {
                if (set.contains(c)) {
                    found = true;
                    break;
                }
            }

            System.out.println(found ? "YES" : "NO");
        }
        sc.close();
    }
}
