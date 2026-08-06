class Solution {
public:
    int longestMountain(vector<int>& arr) {
        int n = arr.size();
        int ans = 0;

        for (int i = 1; i < n - 1; ) {

            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                int count = 1;
                int other = i;

                // Expand left
                while (other > 0 && arr[other] > arr[other - 1]) {
                    other--;
                    count++;
                }

                // Expand right
                while (i < n - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    count++;
                }

                ans = max(ans, count);
            }

            i++;
        }

        return ans;
    }
};