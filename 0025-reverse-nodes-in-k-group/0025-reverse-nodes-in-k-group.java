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
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

    
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        while (count >= k) {
            ListNode groupStart = prev.next;
            ListNode groupEnd = curr;

       
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = next;
            }

            groupStart.next = curr;
            prev = groupEnd;
            count -= k;
        }

        return dummy.next;
    }
}
