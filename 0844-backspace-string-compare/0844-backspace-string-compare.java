class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> First = new Stack<>();
        Stack<Character> Second = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                First.push(s.charAt(i));
            } else {
                if (!First.isEmpty()) {
                    First.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                Second.push(t.charAt(i));
            } else {
                if (!Second.isEmpty()) {
                    Second.pop();
                }
            }
        }

        return First.equals(Second);
    }
}