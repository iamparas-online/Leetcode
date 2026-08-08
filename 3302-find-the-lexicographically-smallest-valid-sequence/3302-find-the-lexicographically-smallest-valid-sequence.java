class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // right[i] = how many characters of word2
        // can be matched after position i
        int[] right = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }

            right[i] = m - 1 - j;
        }

        int[] ans = new int[m];

        int j2 = 0;
        boolean changed = false;

        for (int i = 0; i < n && j2 < m; i++) {

            // Normal match
            if (word1.charAt(i) == word2.charAt(j2)) {
                ans[j2] = i;
                j2++;
            }

            // one allowed change
            else if (!changed && right[i + 1] >= m - j2 - 1) {
                ans[j2] = i;
                j2++;
                changed = true;
            }
        }

        if (j2 == m) {
            return ans;
        }

        return new int[0];
    }
}