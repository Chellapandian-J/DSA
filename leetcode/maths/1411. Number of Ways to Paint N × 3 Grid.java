class Solution {
    private static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {
        long A = 6; // ABA patterns
        long B = 6; // ABC patterns

        for (int i = 2; i <= n; i++) {
            long newA = (3 * A + 2 * B) % MOD;
            long newB = (2 * A + 2 * B) % MOD;
            A = newA;
            B = newB;
        }

        return (int)((A + B) % MOD);
    }
}
/*You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.

 

Example 1:


Input: n = 1
Output: 12
Explanation: There are 12 possible way to paint the grid as shown.
Example 2:

Input: n = 5000
Output: 30228214
time Complexity: O(n)
Space Complexity: O(1) */