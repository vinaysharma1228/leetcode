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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the linked list
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Determine the effective rotation value
        int effectiveRotation = k % length;
        if (effectiveRotation == 0) {
            return head; // No rotation needed
        }

        // Step 3: Find the new tail
        ListNode newTail = head;
        for (int i = 1; i < length - effectiveRotation; i++) {
            newTail = newTail.next;
        }

        // Step 4: Update pointers to rotate the list
        ListNode newHead = newTail.next;
        newTail.next = null; // Set the new tail's next to null
        current.next = head; // Connect the old tail to the old head

        return newHead;
    }
}
