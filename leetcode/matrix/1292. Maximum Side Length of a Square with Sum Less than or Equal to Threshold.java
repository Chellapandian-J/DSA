class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int r = mat.length;
        int c = mat[0].length;
        int maxSide = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 1; i + k <= r && j + k <= c; k++) {
                    int sum = 0;
                    for (int x = i; x < i + k; x++) {
                        for (int y = j; y < j + k; y++) {
                            sum += mat[x][y];
                        }
                    }
                    if (sum <= threshold) {
                        maxSide = Math.max(maxSide, k);
                    } else {
                        break;
                    }
                }
            }
        }
        return maxSide;
    }
}
/*given a m x n matrix mat and an integer threshold, return the maximum side length of a square with a sum less than or equal to threshold or return 0 if there is no such square.

example:
Input: mat = [[1,1,3,2,4,3,2],
                [1,1,3,2,4,3,2],
                [1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than or equal to 4 is
2 as shown.

time complexity: O(m^2 * n^2)
space complexity: O(1)*/