class Solution {
    public int kthElement(int a[], int b[], int k) {
        if(a.length>b.length) return kthElement(b,a,k);
        int low=Math.max(0,k-b.length);
        int high=Math.min(a.length,k);
        while(low<=high){
            int x=low+(high-low)/2;
            int y=k-x;
            int aleft=(x==0)?Integer.MIN_VALUE:a[x-1];
            int aright=(x==a.length)?Integer.MAX_VALUE:a[x];
            int bleft=(y==0)?Integer.MIN_VALUE:b[y-1];
            int bright=(y==b.length)?Integer.MAX_VALUE:b[y];
            if(aleft<=bright && bleft<=aright) return Math.max(aleft,bleft);
            else if(aleft>bright) high=x-1;
            else low=x+1;
        }
        return -1;
    }
}