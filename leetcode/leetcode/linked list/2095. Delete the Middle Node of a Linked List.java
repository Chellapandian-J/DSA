/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode ans=head;
        int count=0;
        while(fast!=null && fast.next!=null){
            ans=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ans.next=slow.next;
        return head;
    }
}
//We track the node just before the middle while slow moves toward the middle.
//Once slow reaches the middle node, we bypass it by linking the ans node directly to the node after the middle.
//t:O(n) S:O(1)