class Solution {
    public int findKRotation(int arr[]) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high]) return low;
            int next=(mid+1)%arr.length;
            int prev=(mid-1+arr.length)%arr.length;
            if(arr[mid]<=arr[prev]&&arr[mid]<=arr[next]) return mid;
            if(arr[low]<=arr[mid]) low=mid+1;
            else high=mid-1;
        }
        return 0;
    }
}