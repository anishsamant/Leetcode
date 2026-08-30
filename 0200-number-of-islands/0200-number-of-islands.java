class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;
    private void dfs(char[][] grid, int i, int j) {
        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < m && newj >= 0 && newj < n && grid[newi][newj] == '1') {
                grid[newi][newj] = '0';
                dfs(grid, newi, newj);
            }
        }
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.offer(new int[]{i, j});
        while (!myQueue.isEmpty()) {
            int[] curr = myQueue.poll();
            for (int[] dir : dirs) {
                int newi = curr[0] + dir[0];
                int newj = curr[1] + dir[1];
                if (newi >= 0 && newi < m && newj >= 0 && newj < n && grid[newi][newj] == '1') {
                    grid[newi][newj] = '0';
                    myQueue.offer(new int[]{newi, newj});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                    // bfs(grid, i, j);
                }
            }
        }

        return count;
    }
}