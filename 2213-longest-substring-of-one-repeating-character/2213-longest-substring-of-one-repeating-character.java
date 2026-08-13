class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix; // longest same-character prefix
        int suffix; // longest same-character suffix
        int max;    // longest repeating substring
        int len;    // length of segment

        Node() {}

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            max = 1;
            len = 1;
        }
    }

    Node[] tree;

    // Merge two child nodes
    Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        Node parent = new Node();

        parent.leftChar = left.leftChar;
        parent.rightChar = right.rightChar;
        parent.len = left.len + right.len;

        // Calculate prefix
        parent.prefix = left.prefix;

        if (left.prefix == left.len &&
            left.rightChar == right.leftChar) {

            parent.prefix = left.len + right.prefix;
        }

        // Calculate suffix
        parent.suffix = right.suffix;

        if (right.suffix == right.len &&
            left.rightChar == right.leftChar) {

            parent.suffix = right.len + left.suffix;
        }

        // Initially take the best from either side
        parent.max = Math.max(left.max, right.max);

        // If boundary characters are same,
        // combine left suffix + right prefix
        if (left.rightChar == right.leftChar) {

            parent.max = Math.max(
                parent.max,
                left.suffix + right.prefix
            );
        }

        return parent;
    }

    // Build segment tree
    void build(char[] s, int index, int l, int r) {

        if (l == r) {
            tree[index] = new Node(s[l]);
            return;
        }

        int mid = (l + r) / 2;

        build(s, index * 2, l, mid);
        build(s, index * 2 + 1, mid + 1, r);

        tree[index] = merge(
            tree[index * 2],
            tree[index * 2 + 1]
        );
    }

    // Update one character
    void update(int index, int l, int r, int pos, char c) {

        // Found the required index
        if (l == r) {
            tree[index] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(index * 2, l, mid, pos, c);
        } else {
            update(index * 2 + 1, mid + 1, r, pos, c);
        }

        // Recalculate current node
        tree[index] = merge(
            tree[index * 2],
            tree[index * 2 + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();

        tree = new Node[4 * n];

        char[] arr = s.toCharArray();

        // Build the tree
        build(arr, 1, 0, n - 1);

        int q = queryIndices.length;

        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];
            char newChar = queryCharacters.charAt(i);

            // Update the string
            arr[index] = newChar;

            // Update segment tree
            update(1, 0, n - 1, index, newChar);

            // Root contains answer for whole string
            answer[i] = tree[1].max;
        }

        return answer;
    }
}