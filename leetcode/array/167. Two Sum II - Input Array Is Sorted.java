class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target) return new int[]{left+1,right+1};
            else if(sum<target) left++;
            else right--;
        }
        return new int[]{};
    }
}

/*167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
You may not use the same element twice, and you must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]

Constraints:
2 <= numbers.length <= 3 * 10^4
-10^3 <= numbers[i] <= 10^3
numbers is sorted in non-decreasing order.

time complexity: O(n) for traversing the array with two pointers, so overall O(n)
space complexity: O(1) as we are not using any additional data structures that grow
*/
