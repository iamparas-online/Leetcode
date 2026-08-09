class Solution {

    int n;
    int[][][] t = new int[2][101][101];

    int solveForAlice(int[] piles, int person, int i, int M) {

        if (i >= n)
            return 0;

        if (t[person][i][M] != -1)
            return t[person][i][M];

        int result;

        if (person == 1)
            result = -1;              // Alice
        else
            result = Integer.MAX_VALUE; // Bob

        int stones = 0;

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {

            stones += piles[i + x - 1];

            if (person == 1) { // Alice

                result = Math.max(result,
                    stones + solveForAlice(
                        piles, 0, i + x, Math.max(M, x)
                    )
                );

            } else { // Bob

                result = Math.min(result,
                    solveForAlice(
                        piles, 1, i + x, Math.max(M, x)
                    )
                );
            }
        }

        return t[person][i][M] = result;
    }

    public int stoneGameII(int[] piles) {

        n = piles.length;

        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < 101; i++) {
                java.util.Arrays.fill(t[p][i], -1);
            }
        }

        return solveForAlice(piles, 1, 0, 1);
    }
}