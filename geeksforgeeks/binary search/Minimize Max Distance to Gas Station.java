class Solution {
    public double minMaxDist(int[] stations, int K) {
        double low=0.0;
        double high=0.0;
        for(int i=1;i<stations.length;i++){
            high=Math.max(high,stations[i]-stations[i-1]);
        }
        while(high-low>1e-6){
            double mid=low+(high-low)/2;
            if(check(stations,K,mid)){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return high;
    }
    private boolean check(int[] stations, int K,double mid){
        int reqstations=0;
        for(int i=1;i<stations.length;i++){
            double gap=stations[i]-stations[i-1];
            reqstations+=(int)(gap/mid);
        }
        return reqstations<=K;
    }
}
