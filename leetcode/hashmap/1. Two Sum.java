class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
//time complexity: O(N) where N is the number of elements in the input array. We traverse the array once, and each lookup and insertion operation in the hash map takes O(1) time on average.
//space complexity: O(N) in the worst case, when all elements in the input array

//or using for loops
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==target-nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
//time complexity: O(N^2) where N is the number of elements in the input array. We have two nested loops, and in the worst case, we compare each element with every other element.
//space complexity: O(1) as we are not using any additional data structures that grow

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/