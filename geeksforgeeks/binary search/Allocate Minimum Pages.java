class Solution {
    public int findPages(int[] arr, int k) {
        if(arr.length<k) return -1;
        int low=0,high=0;
        for(int val:arr){
            low=Math.max(val,low);
            high+=val;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(check(arr,k,mid)) high=mid;
            else low=mid+1;
        }
        return high;
    }
    private boolean check(int[] arr,int k,int mid){
        int allocate=1;
        int sum=0;
        for(int nval:arr){
            sum+=nval;
            if(sum>mid){
                allocate++;
                sum=nval;
            }
            if(allocate>k) return false;
        }
        return true;
    }
}