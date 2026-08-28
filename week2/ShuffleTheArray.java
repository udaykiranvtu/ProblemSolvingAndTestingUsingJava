class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            ans[j++] = nums[i];     // take from first half
            ans[j++] = nums[i + n]; // take from second half
        }
        return ans;
    }
}
