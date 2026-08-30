class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        // Step 1: Find min and max
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        // Step 2: Find indices of min and max
        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == min) {
                idx1 = i;
            }

            if (nums[i] == max) {
                idx2 = i;
            }
        }

        // Step 3: Find left and right positions
        int left = Math.min(idx1, idx2);
        int right = Math.max(idx1, idx2);

        // Step 4: Both from left
        int ans1 = right + 1;

        // Step 5: Both from right
        int ans2 = n - left;

        // Step 6: One from left and one from right
        int ans3 = (left + 1) + (n - right);

        // Step 7: Return minimum
        return Math.min(ans1, Math.min(ans2, ans3));
    }
}