import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            int[] freq = new int[101];
            int count = 0;

            for (int j = i; j < nums.size(); j++) {
                int num = nums.get(j);

                if (freq[num] == 0) {
                    count++;
                }

                freq[num]++;
                ans += count * count;
            }
        }

        return ans;
    }
}