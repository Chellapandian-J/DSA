class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,leftmax=0,rightmax=0,ans=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>leftmax){
                    leftmax=height[left];
                }
                else{
                    ans+=leftmax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>rightmax){
                    rightmax=height[right];
                }
                else{
                    ans+=rightmax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

time complexity: O(N) where N is the number of elements in the input array. We use two pointers to traverse the array from both ends, which takes O(N) time. Overall, the time complexity is O(N).
space complexity: O(1) since we are using a constant amount of extra space for the pointers and the variables to store the maximum heights, which is not counted towards the space complexity. The output is returned as a single integer, so it does not contribute to the space complexity.
*/