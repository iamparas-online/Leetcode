class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> has = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            // get current count; if element doesn't exist, use 0
            has.put(nums[i], has.getOrDefault(nums[i], 0) + 1);

            // check if current count is greater than half
            if(has.get(nums[i]) > nums.length / 2){
                return nums[i];
            }
        }

        return -1;
    }
}