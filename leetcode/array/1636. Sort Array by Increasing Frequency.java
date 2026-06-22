class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Integer[] arr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr,(a,b)->{
            int fa=map.get(a);
            int fb=map.get(b);
            if(fa==fb) return b-a;
            return fa-fb;
        });
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
        return nums;
    }
}
/*Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]

Example 2:
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]

Example 3:
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100

time complexity: O(nlogn) for sorting and O(n) for creating frequency map, so overall O(nlogn)
space complexity: O(n) for storing the frequency of each element in map, so overall O(n)*/