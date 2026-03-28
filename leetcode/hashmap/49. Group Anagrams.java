class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]

time complexity: O(N*KlogK) where N is the number of strings in the input array and K is the maximum length of a string. We iterate through each string and sort it, which takes O(KlogK) time. Therefore, the overall time complexity is O(N*KlogK).
space complexity: O(N*K) for the hash map that stores the anagrams, where N is the number of strings and K is the maximum length of a string. In the worst case, when all strings are anagrams of each other, the space complexity simplifies to O(N*K).
*/