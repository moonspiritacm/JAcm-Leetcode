package com.moonspirit.acm.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代（技巧）。O(n) O(n)/O(logn)
 * <p>
 * 利用栈先进后出的特性，先压入右孩子节点，再压入左孩子节点，每次左孩子节点出栈，遍历左子树，
 * <p>
 * 空间复杂度：主要是迭代过程中显式栈开销，仍然与树深度正相关。平均情况下 O(logn)，最坏情况下树呈链状 O(n)。
 */
//由于栈是“先进后出”的顺序，所以入栈时先将右子树入栈，这样使得前序遍历结果为 “根->左->右”的顺序。
class SolutionC {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.add(node.val);
            if (node.right != null) {
                stk.push(node.right);
            }
            if (node.left != null) {
                stk.push(node.left);
            }
        }
        return res;
    }
}
