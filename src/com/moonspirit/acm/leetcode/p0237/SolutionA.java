package com.moonspirit.acm.leetcode.p0237;

/**
 * 模拟。O(1) O(1)
 */
class SolutionA {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
