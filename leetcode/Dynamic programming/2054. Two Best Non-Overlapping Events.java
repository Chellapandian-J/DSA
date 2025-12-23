//this method also use binary search
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n];
        dp[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], events[i][2]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = events[i][2];
            int l = i + 1, r = n - 1, idx = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (events[mid][0] > events[i][1]) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (idx != -1) {
                val += dp[idx];
            }
            ans = Math.max(ans, val);
        }
        return ans;
    }
}