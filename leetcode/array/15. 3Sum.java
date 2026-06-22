class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> li=new HashSet();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp);
                        li.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(li);
    }
}

//time complexity: O(n^3) for traversing the array and checking all triplets, so overall O(n^3)
//space complexity: O(n) for storing the answer in HashSet, so overall O(n)

//optimized solution
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    li.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum<0)left++;
                else right--;
            }
        }
        return li;
    }
}
//time complexity: O(n^2) for traversing the array and checking all triplets, so overall O(n^2)
//space complexity: O(n) for storing the answer in List, so overall O(n)

/*15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums
[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Constraints:
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
*/