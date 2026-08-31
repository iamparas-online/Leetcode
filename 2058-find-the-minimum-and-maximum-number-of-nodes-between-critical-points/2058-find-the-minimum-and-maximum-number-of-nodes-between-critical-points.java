class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode curr = head;
        ListNode agla = curr.next;
        ListNode prev = null;
        int Index = 1;

        List<Integer> list = new ArrayList<>();

        while (curr != null) {

            if (prev == null || agla == null) {
                // eat 5 star do nothing
            } 
            else {

                if (curr.val < prev.val && curr.val < agla.val) {
                    list.add(Index);
                }

                else if (curr.val > prev.val && curr.val > agla.val) {
                    list.add(Index);
                }
            }

            Index++;
            prev = curr;
            curr = agla;

            if (agla == null) {
                break;
            }

            agla = agla.next;
        }

        if (list.size() < 2) {
            return new int[] {-1, -1};
        }

        int MinDist = Integer.MAX_VALUE;
        int MaxDist = 0;

        for (int i = 0; i < list.size() - 1; i++) {

            int dist = list.get(i + 1) - list.get(i);

            MinDist = Math.min(MinDist, dist);
        }

        MaxDist = list.get(list.size() - 1) - list.get(0);

        return new int[] {MinDist, MaxDist};
    }
}