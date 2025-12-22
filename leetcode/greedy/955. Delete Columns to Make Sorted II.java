class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] fixed = new boolean[n - 1];
        int deletions = 0;

        for (int c = 0; c < m; c++) {
            boolean invalid = false;

            for (int i = 0; i < n - 1; i++) {
                if (!fixed[i] && strs[i].charAt(c) > strs[i + 1].charAt(c)) {
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                deletions++;
                continue;
            }

            for (int i = 0; i < n - 1; i++) {
                if (!fixed[i] && strs[i].charAt(c) < strs[i + 1].charAt(c)) {
                    fixed[i] = true;
                }
            }
        }

        return deletions;
    }
}
