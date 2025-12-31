//its not optimal one and the method feel confusing for me
//time complexity:O(N^2 ∗A(N−1))
import java.util.*;

class Solution {

    // Map: "AB" -> list of possible top blocks
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Step 1: Build the mapping from allowed list
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        // Step 2: Start DFS from the bottom row
        return dfs(bottom);
    }

    // DFS to check if pyramid can be built from this row
    private boolean dfs(String row) {

        // Base case: reached the top
        if (row.length() == 1) {
            return true;
        }

        // Generate all possible next rows
        List<String> nextRows = new ArrayList<>();
        buildNextRows(row, 0, new StringBuilder(), nextRows);

        // Try each possible next row
        for (String next : nextRows) {
            if (dfs(next)) {
                return true;
            }
        }

        return false;
    }

    // Backtracking to build all valid next rows
    private void buildNextRows(String row, int index,
                               StringBuilder sb, List<String> result) {

        // If next row is complete
        if (index == row.length() - 1) {
            result.add(sb.toString());
            return;
        }

        // Get the bottom pair
        String key = row.substring(index, index + 2);

        // If no valid top block, stop this path
        if (!map.containsKey(key)) {
            return;
        }

        // Try all possible top blocks
        for (char c : map.get(key)) {
            sb.append(c);                         // choose
            buildNextRows(row, index + 1, sb, result); // explore
            sb.deleteCharAt(sb.length() - 1);     // un-choose (backtrack)
        }
    }
}
