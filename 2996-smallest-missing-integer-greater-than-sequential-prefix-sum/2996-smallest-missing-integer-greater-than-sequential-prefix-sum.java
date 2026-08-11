class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];
        int n = nums.length;

        Set<Integer> set = new HashSet<>();


        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Store all numbers
        for (int num : nums) {
            set.add(num);
        }

        // Find smallest missing number >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}