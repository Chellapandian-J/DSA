class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ArrayList<Integer> li=new ArrayList<>();
            li.add(entry.getKey());
            li.add(entry.getValue());
            ans.add(li);
        }
        return ans;
    }
}
/*given an array Arr of N integers. The task is to find the frequency of each element in the array.
example 1:
Input:
N = 5
Arr[] = {1, 1, 2, 2, 3}
Output:
1 2
2 2
3 1

example 2:
Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output:
1 1
2 1
3 1
time complexity: O(n) for traversing the array and O(n) for inserting in map, so overall O(n)
space complexity: O(n) for storing the frequency of each element in map, so overall O(n)*/