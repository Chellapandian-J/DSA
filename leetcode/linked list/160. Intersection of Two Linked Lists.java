/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
            a=(a==null)?headB:a.next;
            b=(b==null)?headA:b.next;
        }
        return a;
    }
}/*Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
Example 1:
Input: headA = [4,1,8,4,5], headB = [5,0,1,8,4,5]
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be
0-indexed). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 3 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
Example 2:
Input: headA = [1,9,1,2,4], headB = [3,2,4]
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0-indexed). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:
Input: headA = [2,6,4], headB = [1,5
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From
the head of B, it reads as [1,5]. Since the two lists do not intersect, return null.
time Complexity: O(m+n)
space Complexity: O(1) */