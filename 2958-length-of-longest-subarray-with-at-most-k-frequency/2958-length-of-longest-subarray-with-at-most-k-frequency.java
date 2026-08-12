class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int count=0;
        int max=0;
        for(right = 0;right<nums.length;right++){

            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            count++;

            while(map.get(nums[right])>k){
                
                map.put(nums[left],map.get(nums[left])-1);
                left++;
                count--;
            }
            max=Math.max(max,count);
        }
        return max;

    }
}