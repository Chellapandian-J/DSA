//using min max
class Solution {
    public int minTime(int[] arr, int k) {
        int low=0;
        int high=0;
        for(int ip:arr){
            low=Math.max(ip,low);
            high+=ip;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(check(arr,k,mid)) high=mid;
            else low=mid+1;
        }
        return low;
    }
    private boolean check(int[] arr,int k,int mid){
        int painters=1;
        int sum=0;
        for(int val:arr){
            sum+=val;
            if(sum>mid){
               painters++;
               sum=val; 
            }
            if(painters>k) return false;
        }
        return true;
    }
}
