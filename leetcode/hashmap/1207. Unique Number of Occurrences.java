class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> set=new HashSet<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(!set.add(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
/*
given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:
Input: arr = [1,2]
Output: false
Explanation: Both 1 and 2 have 1 occurrence.
Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

time complexity: O(N) where N is the number of elements in the input array. We iterate through the array to build the frequency map, which takes O(N) time. Then, we iterate through the frequency map to check for unique occurrences, which takes O(M) time, where M is the number of unique integers in the array. Overall, the time complexity is O(N + M), which simplifies to O(N) in the worst case when all integers are unique.
space complexity: O(N) for the frequency map and O(M) for the set of occurrences, resulting in O(N + M) space complexity. In the worst case, when all integers are unique, the space complexity simplifies to O(N).
*/