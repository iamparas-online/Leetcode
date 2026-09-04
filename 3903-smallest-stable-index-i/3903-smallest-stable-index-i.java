class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int [] leftmax = new int[nums.length];
        int [] rightmin = new int[nums.length];
        int lastIndex = nums.length - 1;

        leftmax[0]=nums[0];
        rightmin[lastIndex] = nums[lastIndex];

        for(int i=1;i<nums.length;i++){
            leftmax[i] = Math.max(leftmax[i-1], nums[i]);
        }

        for (int i = lastIndex - 1; i >= 0; i--) {
            rightmin[i] = Math.min(rightmin[i + 1], nums[i]);
        }


        for (int i = 0; i < nums.length; i++) {
            if (leftmax[i] - rightmin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}