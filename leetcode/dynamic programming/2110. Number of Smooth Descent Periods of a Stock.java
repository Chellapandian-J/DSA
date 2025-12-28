class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long count = 1;
        long add = 1;

        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                add++;
            } else {
                add = 1;
            }
            count += add;
        }
        return count;
    }
}
