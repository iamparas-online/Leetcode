class Solution {
    public int lastStoneWeight(int[] stones) {

        // Biggest stone comes first
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            pq.add(stone);
        }

        // Keep smashing while there are at least 2 stones
        while (pq.size() > 1) {

            int y = pq.poll();  // biggest
            int x = pq.poll();  // second biggest

            // If they are different, put the difference back
            if (y != x) {
                pq.add(y - x);
            }
        }

        // If no stone is left
        if (pq.isEmpty()) {
            return 0;
        }

        // Otherwise return the last stone
        return pq.poll();
    }
}