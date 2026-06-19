class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max=-1;
        int secmax=-1;
        for(int x:arr){
            if(x>max){
                secmax=max;
                max=x;
            }
            else if(x>secmax && x!=max){
                secmax=x;
            }
        }
        return secmax;
    }
}
//time complexity: O(n) for finding second largest, so overall O(n) space complexity: O(1) as we are using only constant extra space

class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        Arrays.sort(arr);
        int max=arr[arr.length-1];
        for(int i=arr.length-2;i>-1;i--){
            if(arr[i]!=max){
                return (int)arr[i];
            }
        }
        return -1;
    }
}
//time complexity: O(nlogn) for sorting and O(n) for finding second largest, so overall O(nlogn)
//space complexity: O(1) as we are using only constant extra space

/*given an array Arr of N integers. The task is to find the second largest element in the array. If the second largest element does not exist, return -1.
example 1:
Input:
N = 5
Arr[] = {1, 2, 0, 3, 2}
Output: 2

example 2:
Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 4

example 3:
Input:
N = 5
Arr[] = {1, 1, 1, 1, 1}
Output: -1
*/