import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of pairs
        sc.nextLine();         // consume newline

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String first = sc.next();
            String second = sc.next();
            String pair = first + " " + second;  // represent pair as a string
            set.add(pair);
            System.out.println(set.size());
        }
        sc.close();
    }
}
