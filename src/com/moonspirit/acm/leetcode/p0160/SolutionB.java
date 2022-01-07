package com.moonspirit.acm.leetcode.p0160;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表。O(m+n) O(m)
 */
public class SolutionB {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
