class Solution {
    public static int largest(int[] arr) {
        // code here
        Arrays.sort(arr);
        return (int) arr[arr.length-1];
    }
}
/*given an array Arr of N integers. The task is to find the largest element in it.

example 1:
Input:
N = 5
Arr[] = {1, 2, 0, 3, 2}
Output: 3

time complexity: O(NlogN)
space complexity: O(1)*/

// or optimized solution
class Solution {
    public static int largest(int[] arr) {
        // code here
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
//time complexity: O(N)
//space complexity: O(1)