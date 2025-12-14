class Solution {
    public int median(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            low=Math.min(mat[i][0],low);
            high=Math.max(mat[i][col-1],high);
        }
        int required=(row*col)/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=0;
            for(int i=0;i<row;i++){
                count+=upperbound(mat[i],mid);
            }
            if(count<=required) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    private int upperbound(int mat[],int target){
        int l=0,r=mat.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(mat[mid]<=target) l=mid+1;
            else r=mid;
        }
        return l;
    }
}