import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        String s = reader.readLine().trim();

        // Duplicate the string to handle circular rotations easily
        String doubled = s + s;
        int len = 2 * n;

        // Preprocess string for Manacher's Algorithm
        char[] t = new char[2 * len + 3];
        t[0] = '^';
        t[1] = '#';
        for (int i = 0; i < len; i++) {
            t[2 * i + 2] = doubled.charAt(i);
            t[2 * i + 3] = '#';
        }
        t[t.length - 1] = '$';

        int[] p = new int[t.length];
        int center = 0, right = 0;

        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            } else {
                p[i] = 0;
            }

            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        StringBuilder sb = new StringBuilder();

        // For each rotation index k from 0 to n-1
        // The window in the doubled string is [k, k + n - 1]
        for (int k = 0; k < n; k++) {
            int maxLen = 1;
            // Iterate through all potential centers inside the window [k, k + n - 1]
            // Each position `i` in the doubled string generates two centers in `t`:
            // 1. Odd-length center at `2 * i + 2`
            // 2. Even-length center at `2 * i + 3`
            for (int i = k; i < k + n; i++) {
                // Check odd-length palindrome centered at i
                int t_odd = 2 * i + 2;
                int rad_odd = p[t_odd];
                // The palindrome must be fully contained within [k, k + n - 1]
                // Allowed radius on each side from index i: min(i - k, (k + n - 1) - i)
                int max_rad_allowed = Math.min(i - k, (k + n - 1) - i);
                int effective_rad_odd = Math.min(rad_odd, max_rad_allowed);
                maxLen = Math.max(maxLen, 2 * effective_rad_odd + 1);

                // Check even-length palindrome centered between i and i + 1
                int t_even = 2 * i + 3;
                int rad_even = p[t_even];
                int max_rad_allowed_even = Math.min(i - k, (k + n - 1) - (i + 1));
                if (max_rad_allowed_even >= 0) {
                    int effective_rad_even = Math.min(rad_even, max_rad_allowed_even + 1);
                    maxLen = Math.max(maxLen, 2 * effective_rad_even);
                }
            }
            sb.append(maxLen).append("\n");
        }

        System.out.print(sb.toString());
    }
}
