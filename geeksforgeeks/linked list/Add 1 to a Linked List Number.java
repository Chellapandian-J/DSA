/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        head=reverse(head);
        Node curr=head;
        int carry=1;
        while(curr!=null && carry>0){
            int sum=curr.data+carry;
            curr.data=sum%10;
            carry=sum/10;
            if(curr.next==null && carry>0){
                curr.next=new Node(carry);
                carry=0;
            }
            curr=curr.next;
        }
        return reverse(head);
    }
    private static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
/*
Example 1:  
Input: 1->2->3
Output: 1->2->4
Explanation: The linked list represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be 1->2->4.

Example 2:
Input: 4->3->2->1
Output: 4->3->2->2 
Explanation: The linked list represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be 4->3->2->2.

Example 3:
Input: 9
Output: 1->0
Explanation: The linked list represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be 1->0.

time complexity: O(n)
space complexity: O(1)
*/