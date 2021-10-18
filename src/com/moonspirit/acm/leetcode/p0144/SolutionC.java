package com.moonspirit.acm.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代（技巧）。O(n) O(n)
 */
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
