class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<=row-3;i++){
            for(int j=0;j<=col-3;j++){
                if(ismagic(i,j,grid)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean ismagic(int r,int c,int[][] grid){
        if(grid[r+1][c+1]!=5)return false;
        boolean[] seen=new boolean[10];
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                int val=grid[i][j];
                if(val<1 || val>9 || seen[val]){
                    return false;
                }
                seen[val]=true;
            }
        }
        int sum=grid[r][c]+grid[r][c+1]+grid[r][c+2];
        //row
        for(int i=0;i<3;i++){
            if((grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2])!=sum) return false;
        }
        //col
        for(int j=0;j<3;j++){
            if((grid[r][c+j]+grid[r+1][c+j]+grid[r+2][c+j])!=sum) return false;
        }
        //left to right diagonal
        if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2]!=sum) return false;
        //right to left diagonal
        if(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]!=sum) return false;
        return true;
    }
}
//t:O(r*c) s:O(1)