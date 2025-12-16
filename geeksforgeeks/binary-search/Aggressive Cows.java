import java.util.*;
class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int ans=0;
        int low=0;
        int high = stalls[stalls.length - 1] - stalls[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(stalls,mid,k)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    private boolean check(int[] stalls,int mid,int k){
        int cows=1;
        int lastplace=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastplace>=mid){
                cows++;
                lastplace=stalls[i];
                if(cows==k) return true;
            }
        }
        return false;
    }
}