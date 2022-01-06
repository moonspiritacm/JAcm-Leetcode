package com.moonspirit.acm.leetcode.p0061;

/**
 * 闭合成环。O(n) O(1)
 */
class SolutionA {
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

        n = n - k % n - 1;  // 新链表尾
        curr.next = head;  // 闭合成环
        curr = head;
        while (n > 0) {
            curr = curr.next;
            n--;
        }
        head = curr.next;  // 新链表头
        curr.next = null;  // 断开头尾
        return head;
    }
}
