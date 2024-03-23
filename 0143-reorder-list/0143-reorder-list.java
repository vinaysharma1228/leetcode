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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle node
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Disconnect the first and second halves

        // Step 3: Merge the two lists
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            curr.next = firstHalf;
            firstHalf = firstHalf.next;
            curr = curr.next;
            curr.next = secondHalf;
            secondHalf = secondHalf.next;
            curr = curr.next;
        }

        // Attach any remaining nodes from the first half
        if (firstHalf != null) {
            curr.next = firstHalf;
        }

        head = dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}