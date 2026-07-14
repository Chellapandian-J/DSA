import java.util.*;
class Solution {
    static ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                list.add(arr[i]);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return list;
    }
}
//Time Complexity: O(n), where n is the length of the input array. We are iterating through the array once to populate the LinkedHashMap and ArrayList.
//Space Complexity: O(n), where n is the number of unique elements in the input array. We are using a LinkedHashMap to store the unique elements and their counts, and an ArrayList to store the final result.

//or
import java.util.*;
class Solution {
    static ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        LinkedHashSet<Integer> list=new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        return new ArrayList<>(list);
    }
}
//time Complexity: O(n), where n is the length of the input array. We are iterating through the array once to populate the LinkedHashSet.
//Space Complexity: O(n), where n is the number of unique elements in the input array. We are using a LinkedHashSet to store the unique elements, and then converting it to an ArrayList for the final result.

/*Given an array of integers, the task is to remove duplicates from the array and return the unique elements in the order they first appeared. The provided solution uses a LinkedHashMap or LinkedHashSet to maintain the order of insertion while ensuring that only unique elements are retained. The removeDuplicate method takes an integer array as input and returns an ArrayList containing the unique elements.
Example:
Input: arr = [4, 5, 2, 4, 3, 2, 1]
Output: [4, 5, 2, 3, 1]
In the first solution, we use a LinkedHashMap to store the elements and their counts,
while in the second solution, we use a LinkedHashSet to directly store the unique elements. Both approaches ensure that the order of the elements is preserved.
*/