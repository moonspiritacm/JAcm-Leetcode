package com.moonspirit.acm.leetcode.p0160;

/**
 * 暴力搜索。O(mn) O(1)
 */
public class SolutionA {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        for (ListNode i = headA; i != null; i = i.next) {
            for (ListNode j = headB; j != null; j = j.next) {
                if (i == j) {
                    return i;
                }
            }
        }
        return null;
    }
}
