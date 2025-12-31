class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int low = Arrays.stream(bloomDay).min().getAsInt();
        if((m*k)>bloomDay.length) return -1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(can(bloomDay,m,k,mid)){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean can(int[] bloomDay, int m, int k,int mid){
        int cons=0;
        int boq=0;
        for(int bloom:bloomDay){
            if(bloom<=mid){
                cons++;
                if(cons==k){
                    boq++;
                    cons=0;
                }
            }
            else{
                cons=0;
            }
            if(boq>=m){
                return true;
            }
        }
        return false;
    }
}
