package com.moonspirit.acm.leetcode.p0144;

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

        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}
