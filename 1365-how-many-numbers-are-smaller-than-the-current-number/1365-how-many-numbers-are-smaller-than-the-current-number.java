class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        //creating array 
        int[] arr = new int[nums.length];

        //now loop 
        for(int i=0; i<nums.length; i++){

            //it resets to zero every time 
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }
}