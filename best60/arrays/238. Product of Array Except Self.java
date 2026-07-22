class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        ans[0]=1;
        int suffix=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        for(int i=n-1;i>=0;i--){
            ans[i]*=suffix;
            suffix*=nums[i];
        }
        return ans;
    }
}

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

time complexity: O(N) where N is the number of elements in the input array. We iterate through the array twice to compute the prefix and suffix products, which takes O(N) time. Overall, the time complexity is O(N).
space complexity: O(1) since we are using a constant amount of extra space for the suffix variable and the output array, which is not counted towards the space complexity. The output array is returned as the result, so it does not contribute to the space complexity.
*/
