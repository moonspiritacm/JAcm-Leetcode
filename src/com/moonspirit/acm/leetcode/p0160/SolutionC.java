package com.moonspirit.acm.leetcode.p0160;

/**
 * 双指针。O(m+n) O(1)
 */
public class SolutionC {
    private int getCount(ListNode head) {
        int num = 0;
        while (head != null) {
            head = head.next;
            num++;
        }
        return num;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int na = getCount(headA);
        int nb = getCount(headB);
        if (na > nb) {
            int k = na - nb;
            while (k-- > 0) {
                headA = headA.next;
            }
        } else {
            int k = nb - na;
            while (k-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
