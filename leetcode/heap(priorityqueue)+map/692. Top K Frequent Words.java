import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=
            new PriorityQueue<>((a,b)->{
                if(!a.getValue().equals(b.getValue())){
                    return a.getValue()-b.getValue();
                }
                return b.getKey().compareTo(a.getKey());
            });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }
        List<String> list=new LinkedList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }
}
/*
Given an array of strings words and an integer k, return the k most frequent strings.
The answer should be sorted by frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

time complexity: O(N log k) where N is the number of words in the input array. We iterate through the array to build the frequency map,
which takes O(N) time. Then, we iterate through the frequency map and maintain a min-heap of size k, which takes O(N log k) 
time in the worst case. Finally, we extract the top k elements from the heap, which takes O(k log k) time. Overall, the dominant term is O(N log k).
space complexity: O(N) for the frequency map and O(k) for the heap, resulting in O(N + k) space complexity.
*/