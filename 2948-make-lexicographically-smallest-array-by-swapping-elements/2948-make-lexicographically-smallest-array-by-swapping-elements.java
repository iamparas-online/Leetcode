class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Store {value, original index}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        int left = 0;

        while (left < n) {

            int right = left;

            // Find all values belonging to the same group
            while (right + 1 < n &&
                   arr[right + 1][0] - arr[right][0] <= limit) {
                right++;
            }

            // Get original indices of this group
            int[] indices = new int[right - left + 1];

            for (int i = left; i <= right; i++) {
                indices[i - left] = arr[i][1];
            }

            // Sort original indices
            Arrays.sort(indices);

            // Put smallest values at smallest indices
            for (int i = 0; i < indices.length; i++) {
                ans[indices[i]] = arr[left + i][0];
            }

            left = right + 1;
        }

        return ans;
    }
}