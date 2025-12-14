class Solution {
    int n,m;
    boolean[][] visited;
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    int countDistinctIslands(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        Set<String> shapes=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&& !visited[i][j]){
                    List<String> shape=new ArrayList<>();
                    dfs(grid,i,j,i,j,shape);
                    shapes.add(String.join(";",shape));
                }
            }
        }
        return shapes.size();
    }
    private void dfs(int[][] grid,int i,int j,int r,int c,List<String> shape){
        visited[i][j]=true;
        shape.add((i-r)+","+(j-c));
        for(int[] d:dirs){
            int u=i+d[0];
            int v=j+d[1];
            if(u>=0 && u<m && v>=0 && v<n && !visited[u][v] && grid[u][v]==1){
                dfs(grid,u,v,r,c,shape);
            }
        }
    }
}
