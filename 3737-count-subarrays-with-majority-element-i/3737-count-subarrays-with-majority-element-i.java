class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int result=0;

        for(int i=0; i<nums.length; i++){

            int count=0;

            for(int j=i; j<nums.length; j++){
                int size=j-i+1;

                if(nums[j]==target){
                    count++;
                }

                if(count>size/2){
                    result++;
                }
            }
        }
        return result;
    }
}