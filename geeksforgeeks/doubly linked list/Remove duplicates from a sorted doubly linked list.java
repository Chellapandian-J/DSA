/*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node curr=head;
        while(curr!=null & curr.next!=null){
            if(curr.data==curr.next.data){
                Node dup=curr.next;
                curr.next=dup.next;
                if(dup.next!=null){
                    dup.next.prev=curr;
                }
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }
}
/*Given a sorted doubly linked list, the task is to remove duplicate nodes from the given list.
Example 1:
Input:
Doubly Linked List: 1 <-> 2 <-> 2 <-> 4 <-> 5 <-> 5 <-> 5
Output: 1 2 4 5
time complexity: O(n)
space complexity: O(1)
*/