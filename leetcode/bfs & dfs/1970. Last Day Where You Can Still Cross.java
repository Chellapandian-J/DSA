class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = cells.length;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];

        // Flood cells up to "day"
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1; // water
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        // Start BFS from top row
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == row - 1) return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < row && nc < col &&
                    !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}
/* 
leetcode link: https://leetcode.com/problems/last-day-where-you-can-still-cross/
You are given two integers row and col and an array cells where cells[i] = [ri, ci] indicates that on the ith day, the cell on the rith row and cith column (1-indexed) will be flooded with water. You want to find the last day that you can still walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, down). Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
example 1:
Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2
example 2:
Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
Output: 1

Constraints:
2 <= row, col <= 2 * 10^4
4 <= row * col <= 2 * 10^4
cells.length == row * col
cells[i].length == 2
//t:O(R*C*log(R*C)) S:O(row × col)
//it can solve optimal using union find method
*/