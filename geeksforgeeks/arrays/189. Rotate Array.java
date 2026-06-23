class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    private void reverse(int l,int r,int[] nums){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}

/*You are given an integer array nums. You are also given an integer k.
You need to rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]

time complexity: O(N) where N is the number of elements in the input array. We traverse the array once, and each lookup and insertion operation in the hash map takes O(1) time on average.
space complexity: O(1) as we are not using any additional data structures that grow
*/