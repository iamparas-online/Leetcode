class Solution {
    public boolean isPalindrome(int n) {

        if (n < 0)
            return false;

        int original = n;
        int rev = 0;

        while (n != 0) {

            int digit = n % 10;
            n = n / 10;

            rev = (rev * 10) + digit;
        }

        return original == rev;
    }
}