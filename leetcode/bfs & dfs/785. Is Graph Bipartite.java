class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1, color, graph)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int u, int c, int[] color, int[][] graph) {
        color[u] = c;
        for (int v : graph[u]) {
            if (color[v] == 0) {
                if (!dfs(v, -c, color, graph)) return false;
            } else if (color[v] == c) {
                return false;
            }
        }
        return true;
    }
}
