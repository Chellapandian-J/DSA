class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0,high=n-1;
        while(low<=high){
        int mid=low+(high-low)/2;
        int row=0;
        for(int i=0;i<m;i++){
            if(mat[i][mid]>mat[row][mid]) row=i;
        }
        int left=(mid-1>=0)?mat[row][mid-1]:-1;
        int right=(mid+1<n)?mat[row][mid+1]:-1;
        if(mat[row][mid]>left && mat[row][mid]>right) return new int[]{row,mid};
        if(mat[row][mid]<left) high=mid-1;
        else low=mid+1;
        }
        return new int[]{-1,-1};
    }
}