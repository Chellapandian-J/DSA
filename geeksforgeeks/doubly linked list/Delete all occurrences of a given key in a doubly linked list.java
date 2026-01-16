// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node curr=head;
        while(curr!=null){
            if(curr.data==x){
                if(curr.prev==null){
                    head=curr.next;
                    if(head!=null){
                        head.prev=null;
                    }
                }
                else{
                    curr.prev.next=curr.next;
                    if(curr.next!=null){
                        curr.next.prev=curr.prev;
                    }
                }
            }
            curr=curr.next;
        }
        return head;
    }
}
/*  Function to delete all occurrences of a given key
    in a doubly linked list.
    head: head of the doubly linked list
    x: key to be deleted
    return: head of the modified list
    
time complexity: O(n)
space complexity: O(1)  
*/