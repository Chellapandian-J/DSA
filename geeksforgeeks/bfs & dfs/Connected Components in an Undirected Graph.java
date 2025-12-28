import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                bfs(i, adj, vis, comp);
                Collections.sort(comp);
                result.add(comp);
            }
        }

        return result;
    }

    private void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> comp) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            comp.add(node);

            for (int nbr : adj.get(node)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}
