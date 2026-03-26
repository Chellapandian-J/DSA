class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum=0;
        int max=0,left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while((long)nums[right]*(right-left+1)-sum>k){
                sum-=nums[left];
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
/*
Given an array of integers nums and an integer k, return the maximum possible frequency of an element
after performing at most k operations.
In one operation, you can choose an index of nums and increment the element at that index by 1.
Example 1:
Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and increment the second element two times to make nums = [4,4,4].
The frequency of the most frequent element is 3.
Example 2:
Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times and increment the second element two times to make nums = [4,4,8,13].
- Increment the second element four times and increment the third element once to make nums = [1,8,8,13].
- Increment the third element five times to make nums = [1,4,13,13].
The frequency of the most frequent element is 2.
Example 3:
Input: nums = [3,9,6], k = 2
Output: 1
Explanation: We can increment any element at most once, so the frequency of the most frequent element in nums is 1.

time complexity: O(N log N) due to the sorting step. The two-pointer technique runs in O(N) time, resulting in an overall time complexity of O(N log N).
space complexity: O(1) if we ignore the space used for sorting, otherwise O(N) due to the space used by the sorting algorithm.
*/