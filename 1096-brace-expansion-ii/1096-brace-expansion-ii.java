class Solution {

    int i = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> set = parse(expression);

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }

    Set<String> parse(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            char c = s.charAt(i);

            if (c == '{') {

                i++;
                Set<String> inside = parse(s);
                i++;

                current = multiply(current, inside);

            } 
            else if (c == ',') {

                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;

            } 
            else {

                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(c));

                current = multiply(current, letter);

                i++;
            }
        }

        result.addAll(current);

        return result;
    }

    Set<String> multiply(Set<String> a, Set<String> b) {

        Set<String> ans = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                ans.add(x + y);
            }
        }

        return ans;
    }
}