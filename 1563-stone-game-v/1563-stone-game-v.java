class Solution {
    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // Prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[i][j] = maximum score we can get
        // from subarray i...j
        int[][] dp = new int[n][n];

        // Length of subarray
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                // Try every possible split
                for (int k = i; k < j; k++) {

                    int leftSum = prefix[k + 1] - prefix[i];
                    int rightSum = prefix[j + 1] - prefix[k + 1];

                    if (leftSum < rightSum) {

                        // Take left sum and continue with left
                        dp[i][j] = Math.max(
                            dp[i][j],
                            leftSum + dp[i][k]
                        );

                    } 
                    else if (leftSum > rightSum) {

                        // Take right sum and continue with right
                        dp[i][j] = Math.max(
                            dp[i][j],
                            rightSum + dp[k + 1][j]
                        );

                    } 
                    else {

                        // Equal → choose the better side
                        dp[i][j] = Math.max(
                            dp[i][j],
                            leftSum + Math.max(
                                dp[i][k],
                                dp[k + 1][j]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}