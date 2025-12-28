class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++) dp[i] = 1;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                for (int r = 0; r < rows; r++) {
                    if (strs[r].charAt(j) > strs[r].charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxKeep = 0;
        for (int v : dp) maxKeep = Math.max(maxKeep, v);

        return cols - maxKeep;
    }
}
