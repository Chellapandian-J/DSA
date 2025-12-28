class Solution {
    public int rowWithMax1s(int arr[][]) {
        int m=arr.length;
        int n=arr[0].length;
        int low=0,high=m-1;
        int ans=-1;
        int maxone=0;
        for(int i=0;i<m;i++){
            int firstone=firstindex(arr[i],n);
            if(firstone!=-1){
                int one=n-firstone;
                if(one>maxone){
                    maxone=one;
                    ans=i;
                }
            }
        }
        return ans;
    }
    private int firstindex(int[] arr,int col){
        int low=0,high=col-1;
        int val=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==1){
                val=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return val;
    }
}