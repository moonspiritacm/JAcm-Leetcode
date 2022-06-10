package com.moonspirit.acm.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。O(n) O(n)/O(logn)
 * <p>
 * 空间复杂度：主要是递归栈开销，与树深度正相关。平均情况下 O(logn)，最坏情况下树呈链状 O(n)。
 */
class SolutionA {
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}
