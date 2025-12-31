class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = 0;
        for (int m : nums) {
            high += m;
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cur = 0;
            int count = 1;
            for (int n : nums) {
                if (cur + n <= mid) {
                    cur += n;
                } else {
                    count++;
                    cur = n;
                }
            }
            if (count <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
