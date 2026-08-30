class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> myQueue = new LinkedList<>();
        int freshOranges = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    myQueue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[] divider = new int[]{-1, -1};

        myQueue.offer(divider);
        int minutes = 0;

        while (!myQueue.isEmpty()) {
            int[] curr = myQueue.poll();
            if (curr[0] == -1) {
                minutes++;
                if (!myQueue.isEmpty()) myQueue.offer(divider);
            } else {
                for (int[] dir : dirs) {
                    int newi = curr[0] + dir[0];
                    int newj = curr[1] + dir[1];
                    if (newi >= 0 && newi < m && newj >=0 && newj < n && grid[newi][newj] == 1) {
                        freshOranges--;
                        grid[newi][newj] = 2;
                        myQueue.offer(new int[]{newi, newj});
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes - 1 : -1;
    }
}