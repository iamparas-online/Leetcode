class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long low = 1;
        long high = (long) k * getMin(coins);

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins, n) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins, int n) {
        long count = 0;

        // All non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long currentLcm = 1;
            boolean valid = true;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;

                    currentLcm = lcm(currentLcm, coins[i]);

                    // No multiple of this LCM can be <= x
                    if (currentLcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            // Inclusion-Exclusion
            if (bits % 2 == 1) {
                count += x / currentLcm;
            } else {
                count -= x / currentLcm;
            }
        }

        return count;
    }

    private long getMin(int[] coins) {
        int min = coins[0];

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}