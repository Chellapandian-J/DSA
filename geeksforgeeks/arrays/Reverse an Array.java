class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n=arr.length;
        for(int i=0;i<n/2;i++){
            int temp=arr[n-1-i];
            arr[n-1-i]=arr[i];
            arr[i]=temp;
        }
    }
}
/*given an array of integers, the task is to reverse the array. The reversed array must be printed as output.
example 1:
Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 5 4 3 2 1

example 2:
Input:
N = 4
Arr[] = {1, 2, 3, 4}
Output: 4 3 2 1

time complexity: O(n) for reversing the array, so overall O(n)
space complexity: O(1) as we are reversing the array in place without using any extra space*/