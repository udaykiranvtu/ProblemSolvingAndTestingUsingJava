import java.util.*;

public class Solution {
    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        // Loop through possible starting points
        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            // Compute sum of subarray of length m
            for (int j = 0; j < m; j++) {
                sum += s.get(i + j);
            }
            if (sum == d) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of squares
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }
        int d = sc.nextInt(); // Ron's birth day
        int m = sc.nextInt(); // Ron's birth month

        System.out.println(birthday(s, d, m));
    }
}
