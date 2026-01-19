/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        if(head==null) return arr;
        Node left=head;
        Node right=head;
        while(right.next!=null){
            right=right.next;
        }
        while(left!=null && right!=null && left!=right && left!=right.next){
            int sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer> pair=new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                arr.add(pair);
                left=left.next;
                right=right.prev;
            }
            else if(sum<target){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        return arr;
    }
}
/*Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

example:
Input:
Doubly Linked List: 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
Target=7
Output:
1 6
2 5

time complexity: O(n)
space complexity: O(1)
*/