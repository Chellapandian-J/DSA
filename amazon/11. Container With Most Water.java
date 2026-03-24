class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,maxarea=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int width=right-left;
            maxarea=Math.max(maxarea,h*width);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
    }
}
/*11. Container With Most Water medium
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:
Input: height = [1,1]
Output: 1

time complexity: O(n)
space complexity: O(1)
*/