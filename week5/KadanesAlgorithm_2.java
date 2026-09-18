class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = nums[0], maxSum = nums[0];
        int currentMin = nums[0], minSum = nums[0];

        for (int num : nums) {
            totalSum += num;

            // Kadane’s for maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane’s for minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all numbers are negative, return maxSum directly
        if (maxSum < 0) {
            return maxSum;
        }

        // Otherwise, maximum is either normal max or circular max
        // Circular max is valid only if minSum != totalSum
        return Math.max(maxSum, totalSum - minSum);
    }
}
