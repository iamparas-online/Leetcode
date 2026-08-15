class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            freq[s.charAt(right) - 'a']++;

            // If it appears more than twice, move left
            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // Current window length
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}