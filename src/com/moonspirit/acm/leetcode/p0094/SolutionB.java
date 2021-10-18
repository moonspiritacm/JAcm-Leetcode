package com.moonspirit.acm.leetcode.p0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代（通用）。O(n) O(n)/O(logn)
 */
class SolutionB {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (true) {
            // 处理左子树：不断入栈，直到叶子结点
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            // 处理右子树：栈顶出栈，转向右子树
            if (stk.isEmpty()) {
                break;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
