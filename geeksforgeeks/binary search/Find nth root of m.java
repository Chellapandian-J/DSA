class Solution {
    public int nthRoot(int n, int m) {
        int low=1,high=m;
        if(m==0) return 0;
        if(m==1) return 1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int check=loop(mid,n,m);
            if(check==0) return mid;
            if(check<0) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    private int loop(int mid,int n,int m){
         long result=1;
         for(int i=0;i<n;i++){
             result*=mid;
             if(result>m) return 1;
         }
         if(result==m) return 0;
         return -1;
    }
}