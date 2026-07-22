class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    li.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                    while(l<r && nums[l]==nums[l+1])l++;
                    while(l<r && nums[r]==nums[r-1])r--;
                    l++;
                    r--;
                }
                else if(sum<0) l++;
                else r--;
            }
        }
        return li;
    }
}

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: [[0]]

time complexity: O(N^2) where N is the number of elements in the input array. We sort the array, which takes O(N log N) time, and then we use a nested loop to find the triplets, which takes O(N^2) time. Overall, the time complexity is O(N^2).
space complexity: O(1) since we are using a constant amount of extra space for the pointers and the output list, which is not counted towards the space complexity. The output list is returned as the result, so it does not contribute to the space complexity.
*/