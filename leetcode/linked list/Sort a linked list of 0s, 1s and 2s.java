class Solution {
    static Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        Node zeroDummy = new Node(-1);
        Node oneDummy  = new Node(-1);
        Node twoDummy  = new Node(-1);

        Node zero = zeroDummy;
        Node one  = oneDummy;
        Node two  = twoDummy;

        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next  = twoDummy.next;
        two.next  = null;

        return zeroDummy.next;
    }
}
/*Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
Time Complexity: O(n)
Space Complexity: O(1) */