class Solution {
    public int jump(int[] nums) {
        int far=0;
        int end=0;
        int jump=0;

        for(int i=0; i<nums.length-1; i++){

            far=Math.max(far,i+nums[i]);

            if(i==end){
                end=far;
                jump++;
            }
        }
        return jump;
    }
}