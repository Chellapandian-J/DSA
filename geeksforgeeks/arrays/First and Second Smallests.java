class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        Arrays.sort(arr);
        int[] arr1=Arrays.stream(arr).distinct().toArray();
        ArrayList<Integer> li=new ArrayList<>();
        li.add(arr1[0]);
        if(arr1.length==1) li.set(0,-1);
        else li.add(arr1[1]);
        return li;
    }
}
//time complexity: O(nlogn) for sorting and O(n) for distinct operation, so overall O(nlogn)

//easier and optimal solution with O(n) time complexity and O(1) space complexity
class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> li=new ArrayList<>();
        li.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[0]!=arr[i]){
                li.add(arr[i]);
                return li;
            }
        }
        li.clear();
        li.add(-1);
        return li;
    }
}
//or
class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        int min=Integer.MAX_VALUE;
        int secondmin=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                secondmin=min;
                min=arr[i];
            }
            else if(arr[i]<secondmin && arr[i]!=min){
                secondmin=arr[i];
            }
        }
        ArrayList<Integer> li=new ArrayList<>();
        li.add(min);
        if(secondmin==Integer.MAX_VALUE) li.add(-1);
        else li.add(secondmin);
        return li;
    }
}
/*given an array of integers, the task is to find the smallest and second smallest elements in the array. If the second smallest element does not exist, return -1.
example:
Input: arr[] = {1, 2, 3, 4, 5}
Output: 1 2

Input: arr[] = {1, 1, 1, 1}
Output: 1 -1
*/