import java.util.*;

public class Solution {
    static int[] maxSubarray(int[] arr) {
        // Maximum Subarray Sum (Kadane’s Algorithm)
        int currentSum = arr[0];
        int maxSubarraySum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);
        }

        // Maximum Subsequence Sum
        int maxSubsequenceSum = 0;
        boolean hasPositive = false;
        int maxElement = arr[0];
        for (int num : arr) {
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
            if (num > maxElement) {
                maxElement = num;
            }
        }
        if (!hasPositive) {
            maxSubsequenceSum = maxElement;
        }

        return new int[]{maxSubarraySum, maxSubsequenceSum};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] result = maxSubarray(arr);
            System.out.println(result[0] + " " + result[1]);
        }
        sc.close();
    }
}
