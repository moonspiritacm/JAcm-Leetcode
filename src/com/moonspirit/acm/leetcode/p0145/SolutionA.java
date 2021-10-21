package com.moonspirit.acm.leetcode.p0145;

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
        dfs(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}
