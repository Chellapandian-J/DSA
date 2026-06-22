class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = dp[i + 1][n] + s1.charAt(i);
        }

        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = dp[m][j + 1] + s2.charAt(j);
        }

        // Fill DP table
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(
                        s1.charAt(i) + dp[i + 1][j],
                        s2.charAt(j) + dp[i][j + 1]
                    );
                }
            }
        }

        return dp[0][0];
    }
}

/*
Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds 115 to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, the minimum sum is 115 + 116 = 231.

Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn it into "let",
adds 100 + 101 + 101 = 302 to the sum.
Deleting "e" from "leet" adds 101 to the sum.
At the end, the minimum sum is 302 + 101 = 403.

time complexity: O(m*n)
space complexity: O(m*n)
*/