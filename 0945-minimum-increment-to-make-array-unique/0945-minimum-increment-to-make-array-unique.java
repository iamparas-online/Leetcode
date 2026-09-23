class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;

        for(int i=1; i<nums.length; i++){
            if(nums[i]<=nums[i-1]){

                int x = nums[i-1]+1;
                ans += x-nums[i];
                nums[i] = x;
            }
        }
        return ans;
    }
}