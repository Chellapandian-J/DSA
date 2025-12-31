//using prefix sum with sliding window
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }
        long[] prefStrategyProfit = new long[n + 1];
        long[] prefPrices = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefStrategyProfit[i + 1] =
                prefStrategyProfit[i] + (long) strategy[i] * prices[i];
            prefPrices[i + 1] =
                prefPrices[i] + prices[i];
        }
        long bestGain = 0;
        int half = k / 2;
        for (int start = 0; start + k <= n; start++) {
            int mid = start + half;
            int end = start + k;
            long oldContribution =
                prefStrategyProfit[end] - prefStrategyProfit[start];
            long newContribution =
                prefPrices[end] - prefPrices[mid];
            long gain = newContribution - oldContribution;
            bestGain = Math.max(bestGain, gain);
        }
        return baseProfit + bestGain;
    }
}
