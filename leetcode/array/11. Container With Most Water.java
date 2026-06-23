class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int ans=right-left;
            if(height[right]<=height[left]){
                max=Math.max(max,ans*height[right]);
                right--;
            }
            else if(height[left]<height[right]){
                max=Math.max(max,ans*height[left]);
                left++;
            }
        }
        return max;
    }
}

//simple version

class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxarea=0;
        while(left<right){
            int width=right-left;
            int area=width*Math.min(height[left],height[right]);
            maxarea=Math.max(maxarea,area);
            if(height[right]<height[left]) right--;
            else left++;
        }
        return maxarea;
    }
}

/*you are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

example 2:
Input: height = [1,1]
Output: 1

time complexity: O(N) where N is the number of elements in the input array. We traverse the array once, and each lookup and insertion operation in the hash map takes O(1) time on average.
space complexity: O(1) as we are not using any additional data structures that grow
*/