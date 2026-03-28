import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll().getKey();
        }
        return result;
    }
}
/*
given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]

time complexity: O(N log k) where N is the number of elements in the array. We iterate through the array to build the frequency map, which takes O(N) time. Then, we iterate through the frequency map and maintain a min-heap of size k, which takes O(N log k) time in the worst case. Finally, we extract the top k elements from the heap, which takes O(k log k) time. Overall, the dominant term is O(N log k).
space complexity: O(N) for the frequency map and O(k) for the heap, resulting
in O(N + k) space complexity.
*/