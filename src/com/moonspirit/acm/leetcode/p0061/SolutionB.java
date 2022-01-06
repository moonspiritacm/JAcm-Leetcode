package com.moonspirit.acm.leetcode.p0061;

/**
 * 快慢指针。O(n) O(1)
 */
class SolutionB {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        if (k % n == 0) {
            return head;
        }

        k %= n;
        ListNode fast = head;  // 指向原链表尾
        ListNode slow = head;  // 指向新链表尾
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;  // 连接原链表尾
        head = slow.next;  // 指向新链表头
        slow.next = null;  // 断开新链表尾
        return head;
    }
}
