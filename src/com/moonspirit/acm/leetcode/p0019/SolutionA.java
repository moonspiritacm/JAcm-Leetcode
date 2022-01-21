package com.moonspirit.acm.leetcode.p0019;

class SolutionA {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }

        ListNode root = new ListNode();
        ListNode fast = root;
        ListNode slow = root;
        root.next = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
}
