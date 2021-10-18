package com.moonspirit.acm.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代（通用）。O(n) O(n)/O(logn)
 */
class SolutionB {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (true) {
            // 处理左子树：不断入栈，直到叶子结点
            while (root != null) {
                res.add(root.val);
                stk.push(root);
                root = root.left;
            }

            // 处理右子树：栈顶出栈，转向右子树
            if (stk.isEmpty()) {
                break;
            }
            root = stk.pop();
            root = root.right;
        }
        return res;
    }
}
