class Solution {
    public ArrayList<Integer> customSort(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr,0,n/2);
        Arrays.sort(arr,n/2,n);
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<arr.length/2;i++){
            li.add(arr[i]);
        }
        for(int i=arr.length-1;i>arr.length/2-1;i--){
            li.add(arr[i]);
        }
        return li;
    }
}

/*given an array Arr of N integers. The task is to sort the first half of the array in ascending order and the second half in descending order.
example 1:
Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 1 2 3 5 4

example 2:
Input:
N = 4
Arr[] = {1, 2, 3, 4}
Output: 1 2 4 3

time complexity: O(nlogn) for sorting the first half and O(nlogn) for sorting the second half, so overall O(nlogn)
space complexity: O(n) as we are using an extra arraylist to store the sorted elements