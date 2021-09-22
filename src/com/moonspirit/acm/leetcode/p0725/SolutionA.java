package com.moonspirit.acm.leetcode.p0725;

/**
 * 模拟。O(n) O(1)
 * <p>
 * 对于长度为n的链表，均匀分隔成k段。最小分配长度为s=k/n（可能为0）。前k%n个段长度s+1，其余段长度s。
 */
class SolutionA {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (k <= 0) {
            return new ListNode[0];
        }
        if (head == null) {
            return new ListNode[k];
        }

        int n = 0;  // 链表总长度
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }

        int s = n / k;  // 最小分配长度
        int m = n % k;  // 前半段长度
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k && head != null; i++) {
            // 1.存入首元
            res[i] = head;

            // 2.定位末尾
            int cnt = 1;
            if (i < m) {
                cnt = 0;
            }
            while (cnt++ < s) {
                head = head.next;
            }

            // 3.截断末尾
            curr = head.next;
            head.next = null;
            head = curr;
        }
        return res;
    }
}
