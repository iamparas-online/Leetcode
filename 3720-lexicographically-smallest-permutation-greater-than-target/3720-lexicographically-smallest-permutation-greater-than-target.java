class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Count characters of s
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int targetChar = target.charAt(i) - 'a';

            if (count[targetChar] > 0) {

                count[targetChar]--;

                if (canMakeGreater(count, target, i + 1)) {

                    result.append(target.charAt(i));

                    continue;
                }

                count[targetChar]++;
            }


            for (int c = targetChar + 1; c < 26; c++) {

                if (count[c] > 0) {
                    result.append((char) ('a' + c));

                    count[c]--;

                    for (int k = 0; k < 26; k++) {

                        while (count[k] > 0) {
                            result.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return result.toString();
                }
            }
            return "";
        }
        return "";
    }
    private boolean canMakeGreater(
        int[] count,
        String target,
        int start
    ) {
        StringBuilder largest = new StringBuilder();

        for (int c = 25; c >= 0; c--) {

            while (count[c] > 0) {
                largest.append((char) ('a' + c));
                count[c]--;
            }
        }
        for (int i = 0; i < largest.length(); i++) {
            count[largest.charAt(i) - 'a']++;
        }

        String targetSuffix = target.substring(start);

        return largest.toString().compareTo(targetSuffix) > 0;
    }
}