class Solution {

    Boolean[] dp = new Boolean[100001];

    public boolean winnerSquareGame(int n) {

        // Already calculated?
        if (dp[n] != null) {
            return dp[n];
        }

        // Try every square number
        for (int move = 1; move * move <= n; move++) {

            // Can remove all stones?
            if (n - move * move == 0) {
                return dp[n] = true;
            }

            // If opponent loses, I win
            if (!winnerSquareGame(n - move * move)) {
                return dp[n] = true;
            }
        }

        // No winning move
        return dp[n] = false;
    }
}