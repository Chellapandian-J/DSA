class Solution {
    public int arraySum(int arr[]) {
        // code here
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=arr[i];
        }
        return ans;
    }
}

/*You are given an integer array arr of size N. You need to find the sum of all the elements in the array.

Example 1:
Input: N = 5, arr[] = {1, 2, 3, 4, 5}
Output: 15

Example 2:
Input: N = 3, arr[] = {10, 20, 30}
Output: 60

time complexity: O(N) where N is the number of elements in the input array. We traverse the array once, and each lookup and insertion operation in the hash map takes O(1) time on average.
space complexity: O(1) as we are not using any additional data structures that grow
*/