class Solution {
    public int longestValidParentheses(String s) {

        // iterate forward
        int open = 0, close = 0;
        int res = 0;

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                open++;
            }

            if (s.charAt(i) == ')') {
                close++;
            }

            if (close > open) {
                open = 0;
                close = 0;
            }
            else if (close == open) {
                res = Math.max(res, open + close);
            }

            i++;
        }

        // iterate reverse
        i = s.length() - 1;
        open = 0;
        close = 0;

        while (i >= 0) {

            if (s.charAt(i) == '(') {
                open++;
            }

            if (s.charAt(i) == ')') {
                close++;
            }

            if (close < open) {
                open = 0;
                close = 0;
            }
            else if (close == open) {
                res = Math.max(res, open + close);
            }

            i--;
        }

        return res;
    }
}