class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        // Count stones based on remainder
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // If number of remainder-0 stones is even,
        // they don't affect the main game.
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If count[0] is odd, Alice needs one side
        // to have enough stones to force a win.
        return Math.abs(count[1] - count[2]) > 2;
    }
}