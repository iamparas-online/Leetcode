class Solution {
    int n;
    int[][] intervals;
    int[][] next;
    long[][] dp;
    List<Integer>[][] path;

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        n = intervalsList.size();

        intervals = new int[n][4];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = intervalsList.get(i).get(0);
            intervals[i][1] = intervalsList.get(i).get(1);
            intervals[i][2] = intervalsList.get(i).get(2);
            intervals[i][3] = i;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[3], b[3]);
        });

        next = new int[n][1];

        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int low = i + 1;
            int high = n;

            while (low < high) {
                int mid = (low + high) / 2;

                if (intervals[mid][0] > intervals[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i][0] = low;
        }

        dp = new long[n + 1][5];
        path = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = -1;
                path[i][k] = new ArrayList<>();
            }
        }

        solve(0, 4);

        List<Integer> answer = path[0][4];

        Collections.sort(answer);

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    long solve(int i, int k) {
        if (i == n || k == 0) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        // Don't take current interval
        long skipScore = solve(i + 1, k);
        List<Integer> skipPath = path[i + 1][k];

        // Take current interval
        long takeScore = intervals[i][2] + solve(next[i][0], k - 1);

        List<Integer> takePath = new ArrayList<>();
        takePath.add(intervals[i][3]);
        takePath.addAll(path[next[i][0]][k - 1]);

        if (takeScore > skipScore) {
            dp[i][k] = takeScore;
            path[i][k] = takePath;
        } else if (takeScore < skipScore) {
            dp[i][k] = skipScore;
            path[i][k] = skipPath;
        } else {
            if (isSmaller(takePath, skipPath)) {
                dp[i][k] = takeScore;
                path[i][k] = takePath;
            } else {
                dp[i][k] = skipScore;
                path[i][k] = skipPath;
            }
        }

        return dp[i][k];
    }

    boolean isSmaller(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}