import java.util.*;

class Solution {
     
    static class State {
        int r, c;
        int energy;
        int mask;
        int moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;  //getting the grid size
        int n = classroom[0].length();

        int sr = 0, sc = 0;   //starting row and column,position of the starting cell
        int litterCount = 0; //how many litter cells

        // Give every litter an index: 0, 1, 2...
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);  //filling the cell by -1 initially
            for (int j = 0; j < n; j++) {   //scanning the entire classroom
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;    //if we find s,we will store its position
                    sc = j;
                }
                if (classroom[i].charAt(j) == 'L') {  //if we find l,we will give it an id 
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // litter -> 111..like example 3 
        int target = (1 << litterCount) - 1;   // for 3 litter cells...1<<3=1000 and 1000-1=0111
        // starting our BFS
        Queue<State> q = new LinkedList<>();

        q.offer(new State(sr, sc, energy, 0, 0));

        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        visited[sr][sc][energy][0] = true;  // keeping track of the visited states
        int[] dr = {-1, 1, 0, 0};   // our four directions
        int[] dc = {0, 0, -1, 1};
        //processing the BFS
        while (!q.isEmpty()) {
            State cur = q.poll();
            // Collected everything
            if (cur.mask == target) {
                return cur.moves;
            }
            for (int d = 0; d < 4; d++) { // TRYING ALL 4 DIRECTIONS
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                // Invalid cell
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                // Need energy to move
                if (cur.energy == 0) {
                    continue;
                }
                int newEnergy = cur.energy - 1;
                // Reset energy
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }
                // Collect litter
                int newMask = cur.mask;
                int id = litterId[nr][nc];
                if (id != -1) {
                    newMask = newMask | (1 << id);  
                }
                // Already visited
                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }
                visited[nr][nc][newEnergy][newMask] = true;
                q.offer(new State(
                    nr,
                    nc,
                    newEnergy,
                    newMask,
                    cur.moves + 1
                ));
            }
        }
        return -1;
    }
}