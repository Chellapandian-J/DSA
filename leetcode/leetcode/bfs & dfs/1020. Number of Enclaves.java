class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    q.offer(new int[] { i, j });
                    grid[i][j] = 0;
                }
            }
        }

        bfs(grid, q, m, n);

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void bfs(int[][] grid, Queue<int[]> q, int m, int n) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
    }
}
