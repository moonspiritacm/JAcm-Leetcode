package com.moonspirit.acm.leetcode.p0094;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。O(n) O(n)/O(logn)
 */
class SolutionA {
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}
