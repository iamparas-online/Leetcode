class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // best[i] = minimum length of a valid subarray
        // ending at or before index i
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            // Since all values are positive, shrink from left
            // while the window sum is greater than target.
            while (sum > target) {
                sum -= arr[left++];
            }
            // We found a subarray [left...right] with sum = target
            if (sum == target) {
                int currentLength = right - left + 1;
                // Check if there is a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min( answer,currentLength + best[left - 1] );
                }
                // Store the shortest valid subarray seen so far
                if (right == 0) {
                    best[right] = currentLength;
                } else {
                    best[right] = Math.min(best[right - 1], currentLength);
                }
            } else {
                // No new valid subarray ending at right
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}